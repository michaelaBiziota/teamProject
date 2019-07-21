/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


jQuery(Load);
function Load($) {

    var favouriteArray = [];
    $("#favouriteMovies td input").each(function () {
        favouriteArray.push($(this).val());
    });
    var seenArray = [];
    $("#seenMovies td input").each(function () {
        seenArray.push(parseInt($(this).val()));
    });
    var recommendedMovies = [];
    var results = [];


    for (i = 0; i < favouriteArray[i]; i++) {
        let URL = "https://api.themoviedb.org/3/movie/" + favouriteArray[i] + "/recommendations?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&page=1";
        $.ajax({

            url: URL,
            success: handleResponse,
            error: handleError
        });

        function handleResponse(data) {
            console.log(data);

            //unique IDS
            for (i = 0; i < 20; i++) {
                recommendedMovies.push(data.results[i].id);

            }


        }



        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);

        }

    }
    $("#button").on("click", function () {
        var sorted_arr = recommendedMovies.slice().sort();
        for (var i = 0; i < sorted_arr.length - 1; i++) {
            if (sorted_arr[i + 1] === sorted_arr[i]) {
                results.push(sorted_arr[i]);
            }
        }
        console.log(results, recommendedMovies,seenArray);
        for (i = 0; i < results.length; i++) {

            let URL = "https://api.themoviedb.org/3/movie/" + results[i] + "?api_key=e58e3961f5be7e510894dc736fee6937&append_to_response=casts,videos";
            $.ajax({

                url: URL,
                success: handleResponse,
                error: handleError
            });

            function handleResponse(data) {
                console.log(data);
                for (i = 0; i < seenArray.length; i++) {
                    if (seenArray.includes(data.id)===false){
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.id + "'><img src='https://image.tmdb.org/t/p/w300" + data.poster_path + "'></a><h5 id='moviestitle'>" + data.title + "</h5></div></div>");
                    }
                }
            }



            function handleError(jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);

            }
        }

    });

}









