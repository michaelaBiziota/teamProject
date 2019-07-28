jQuery(Load);
function Load($) {
$("#button").css("display","box");
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
        $("#button").css("display","none");
results = recommendedMovies.filter((a, i, aa) => aa.indexOf(a) === i && aa.lastIndexOf(a) !== i);
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
                    if (seenArray.includes(data.id)===false){
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovieThroughRecommendations/" + data.id + "'><img src='https://image.tmdb.org/t/p/w300" + data.poster_path + "'></a><h5 id='moviestitle'>" + data.title + "</h5></div></div>");
                    }
               
            }



            function handleError(jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);

            }
        }

    });

}