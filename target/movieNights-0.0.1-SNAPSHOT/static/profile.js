/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
jQuery(Load);
function Load($) {

    //FAVOURITE MOVIES
    var favouriteArray = [];
    $("#favouriteMovies td").each(function () {
        favouriteArray.push($(this).html());
    });

    for (i = 0; i < favouriteArray.length; i++) {
        if (i === 0) {
            $("#pagetitle").append("<h2>Favorite Movies</h2>");
        }

        let URL = "https://api.themoviedb.org/3/movie/" + favouriteArray[i] + "?api_key=e58e3961f5be7e510894dc736fee6937";
        $.ajax({

            url: URL,
            success: handleResponse,
            error: handleError
        });

        function handleResponse(data) {
            console.log(data);

            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.id + "'><img src='https://image.tmdb.org/t/p/w300" + data.poster_path + "'></a><h5 id='moviestitle'>" + data.title + "</h5></div></div>");
        }

        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        };
    };

    //SEEN MOVIES
    var seenArray = [];
    $("#seenMovies td").each(function () {
        seenArray.push($(this).html());
    });


    for (i = 0; i < seenArray.length; i++) {
        if (i === 0) {
            $("#pagetitle").append("<h2>Already Watched</h2>");
        }
        let URL = "https://api.themoviedb.org/3/movie/" + seenArray[i] + "?api_key=e58e3961f5be7e510894dc736fee6937";
        $.ajax({

            url: URL,
            success: handleResponse,
            error: handleError
        });

        function handleResponse(data) {
            console.log(data);

            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.id + "'><img src='https://image.tmdb.org/t/p/w300" + data.poster_path + "'></a><h5 id='moviestitle'>" + data.title + "</h5></div></div>");
        }

        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
        ;
    }
    ;


    //WATCHLIST
    var watchArray = [];
    $("#watchlist td").each(function () {
        watchArray.push($(this).html());
    });

    for (i = 0; i < watchArray.length; i++) {
        if (i === 0) {
            $("#pagetitle").append("<h2>Watchlist</h2>");
        }
        let URL = "https://api.themoviedb.org/3/movie/" + watchArray[i] + "?api_key=e58e3961f5be7e510894dc736fee6937";
        $.ajax({

            url: URL,
            success: handleResponse,
            error: handleError
        });

        function handleResponse(data) {

            console.log(data);

            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.id + "'><img src='https://image.tmdb.org/t/p/w300" + data.poster_path + "'></a><h5 id='moviestitle'>" + data.title + "</h5></div></div>");


        }


        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);

        }
        ;
    }
    ;
}
