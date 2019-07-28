jQuery(Load);
function Load($) {
//toggleAtr
    $.fn.toggleAttrVal = function (attr, val1, val2) {
        var test = $(this).attr(attr);
        if (test === val1) {
            $(this).attr(attr, val2);
            return this;
        }
        if (test === val2) {
            $(this).attr(attr, val1);
            return this;
        }
        // default to val1 if neither
        $(this).attr(attr, val1);
        return this;
    };
    var movieId = $("#hidden").html();
    let URL = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=e58e3961f5be7e510894dc736fee6937&append_to_response=casts,videos";
    $.ajax({
        url: URL,
        success: handleResponse,
        error: handleError
    });
    function handleResponse(data) {
        console.log(data);
        for (i = 0; i < data.casts.crew.length; i++) {
            if (data.casts.crew[i].department === "Writing") {
                var writer = data.casts.crew[i].name;
                break;
            }
        }
        for (i = 0; i < data.casts.crew.length; i++) {
            if (data.casts.crew[i].department === "Directing") {
                var director = data.casts.crew[i].name;
                break;
            }
        }
        for (i = 0; i < data.videos.results.length; i++) {
            if (data.videos.results[i].type === "Trailer") {
                var trailer = data.videos.results[i].key;
            }
        }
        for (i = 0; i < data.casts.crew.length; i++) {
            if (data.casts.crew[i].department === "Writing") {
                var writer = data.casts.crew[i].name;
                break;
            }
        }
        for (i = 0; i < data.casts.crew.length; i++) {
            if (data.casts.crew[i].department === "Directing") {
                var director = data.casts.crew[i].name;
                break;
            }
        }
        for (i = 0; i < data.videos.results.length; i++) {
            if (data.videos.results[i].type === "Trailer") {
                var trailer = data.videos.results[i].key;
            }
        }
        $("#movie").html(`
   <div class="row">
     <h2 class="text-center" id="title">` + data.title + `</h2>
   </div>
    <div class="row">
     <div class="col-md-3">
       <img src="https://image.tmdb.org/t/p/w300` + data.poster_path + `" class="thumbnail img-fluid">
     </div>
    <div class="col-md-6 my-3">
      <ul class="list-group">
       <li class="list-group-item" id="gen"><strong>Genre: </strong></li>
       <li class="list-group-item"><strong>Released:</strong> ` + data.release_date + `</li>
       <li class="list-group-item"><strong>Runtime:</strong> ` + data.runtime + ` min</li>
       <li class="list-group-item"><strong>Rating:</strong> ` + data.vote_average + `</li>
       <li class="list-group-item"><strong>Director:</strong> ` + director + ` </li>
       <li class="list-group-item"><strong>Writer:</strong> ` + writer + `</li>
       <li class="list-group-item"><strong>Actors:</strong> ` + data.casts.cast[0].name + ', ' + data.casts.cast[1].name +
                ', ' + data.casts.cast[2].name + `</li>
      </ul>
   </div>
<div class="col-md-3"><iframe src="https://www.youtube.com/embed/` + trailer + `" allowfullscreen="allowfullscreen"
      mozallowfullscreen="mozallowfullscreen" msallowfullscreen="msallowfullscreen" oallowfullscreen="oallowfullscreen"
      webkitallowfullscreen="webkitallowfullscreen"></iframe>
    </div>
    <div class="row">
        <div class="well mx-4 mt-0 mb-3 mt-2">
            <h3>Plot</h3>` + data.overview + `<hr>
            <div class="text-center">
                <button id="likebutton" class="btn btn-primary heart fa mx-1 my-1" ><span> Like</span></button>
                <button id="watchlaterbutton" class="btn btn-primary clock fa  mx-1 my-1" ><span> Watch Later</span></button>
                <button id="watchedbutton" class="btn btn-primary eye fa  mx-1 my-1" ><span> Already Watched</span></button>
                <a href="http://imdb.com/title/${data.imdb_id}" target="_blank" class="btn btn-primary fa fa-imdb mx-1 my-1" title="Visit IMDB"> View IMDB</a>
                <a href="http://localhost:8080/movieNights/movies" class="btn btn-primary fa fa-arrow-left mx-1 my-1" title="Back to movies" id="back"> Go Back</a>
            </div>
        </div>
    </div>
        `);
        if (data.genres.length === 1) {
            $("#gen").append(data.genres[0].name);
        } else if (data.genres.length === 2) {
            $("#gen").append(data.genres[0].name + ", " + data.genres[1].name);
        } else {
            $("#gen").append(data.genres[0].name + ", " + data.genres[1].name + ", " + data.genres[2].name);
        }
        //ButtonCheckMessage
        //FAVOURITE
        if ($("#favouritemessage").html() === "ok") {
            $("#likebutton").addClass("fa-heart");
            $("#likebutton").attr("title", "Remove from favourites");
        } else if ($("#favouritemessage").html() === "notok") {
            $("#likebutton").addClass("fa-heart-o");
            $("#likebutton").attr("title", "Add to favourites");
        }
        //SEEN
        if ($("#seenmessage").html() === "ok") {
            $("#watchedbutton").addClass("fa-eye green");
            $("#watchedbutton").attr("title", "Remove from already watched");
        } else if ($("#seenmessage").html() === "notok") {
            $("#watchedbutton").addClass("fa-eye");
            $("#watchedbutton").attr("title", "Add to already watched");
        }
        //WATCH LATER
        if ($("#watchmessage").html() === "ok") {
            $("#watchlaterbutton").addClass("fa-clock-o green");
            $("#watchlaterbutton").attr("title", "Remove from watchlist");
        } else if ($("#watchmessage").html() === "notok") {
            $("#watchlaterbutton").addClass("fa-clock-o");
            $("#watchlaterbutton").attr("title", "Add to watchlist");
        }
        //
        //
        //BUTTONS AJAX TO CALL CONTROLLER
        $("#likebutton").on("click", function () {
            $(this).toggleClass("fa-heart-o fa-heart");
            if ($(this).attr("title") === "Add to favourites") {
                $(this).toggleAttrVal("title", "Remove from favourites", "Add to favourites");
            } else if ($(this).attr("title") === "Remove from favourites") {
                $(this).toggleAttrVal('title', "Add to favourites", "Remove from favourites");
            }
       let URL = "/movieNights/like/" + movieId;
            $.ajax({
                url: URL,
                success: handleResponse,
                error: handleError
            });
        });
        $("#watchlaterbutton").on("click", function () {
            $(this).toggleClass("fa-clock-o fa-clock-o green"); 
            if ($(this).attr("title") === "Add to watchlist") {
            $(this).toggleAttrVal("title", "Remove from watchlist", "Add to watchlist");}
        else if ($(this).attr("title") === "Remove from watchlist") {
                $(this).toggleAttrVal('title', "Add to watchlist", "Remove from watchlist");
            }
            let URL = "/movieNights/watchlist/" + movieId;
            $.ajax({
                url: URL,
                success: handleResponse,
                error: handleError
            });
        });
        $("#watchedbutton").on("click", function () {
            $(this).toggleClass("fa-eye fa-eye green");
            if ($(this).attr("title") === "Add to already watched") {
            $(this).toggleAttrVal("title", "Remove from already watched", "Add to already watched");}
        else if ($(this).attr("title") === "Remove from already watched") {
                $(this).toggleAttrVal('title', "Add to already watched", "Remove from already watched");
            }
            let URL = "/movieNights/seen/" + movieId;
            $.ajax({
                url: URL,
                success: handleResponse,
                error: handleError
            });
        });
         //GO BACK WHERE YOU CAME FROM
        if ($("#camefrom").html()==="mymovies"){
            $("#back").attr("href","http://localhost:8080/movieNights/myMovies").attr("title","Go back to your Movies");
        }else if($("#camefrom").html()==="recommendations"){
             $("#back").attr("href","http://localhost:8080/movieNights/getRecommendations").attr("title","Go back to your Recommendations");
        }
            
    }
    function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);
    }
}