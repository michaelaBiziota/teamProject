jQuery(Load);
function Load($) {

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
     <h2 class="my-2 text-center" id="title">` + data.title + `</h2>
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
            <div class="well mx-4 my-3">
              <h3>Plot</h3>` + data.overview + `<hr>
              <a href="http://imdb.com/title/${data.imdb_id}" target="_blank" class="btn btn-primary">View IMDB</a>
              <a href="http://localhost:8080/movieNights/movies" class="btn btn-primary">Go Back</a>
      <a href="http://localhost:8080/movieNights/like/${data.id}" class="btn btn-primary">Like</a>
      <a href="http://localhost:8080/movieNights/seen/${data.id}" class="btn btn-primary">Already watched</a>
      <a href="http://localhost:8080/movieNights/watchlist/${data.id}" class="btn btn-primary my-1">Add to watchlist</a>
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
    }



    function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);
    }

}



