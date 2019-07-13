jQuery(Load);
function Load($) {

  var movieId = $("#hidden").html();
  let URL = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=e58e3961f5be7e510894dc736fee6937&append_to_response=casts,videos";
  $.ajax({

    url: URL,
    success: handleResponse,
    error: handleError
  });
//TODO GOBACK BUTTON
  function handleResponse(data) {
    console.log(data);
    $("#movie").html(`
          <div class="row ">
            <div class="col-md-4">
              <img src="https://image.tmdb.org/t/p/w300`+ data.poster_path + `" class="thumbnail img-fluid">
            </div>
            <div class="col-md-7">
              <h2>`+ data.title + `</h2>
              <ul class="list-group">
                <li class="list-group-item"><strong>Genre:</strong> `+data.genres[0].name+`</li>
                <li class="list-group-item"><strong>Released:</strong> `+ data.release_date + `</li>
                <li class="list-group-item"><strong>Runtime:</strong> `+ data.runtime + ` min</li>
                <li class="list-group-item"><strong>Rating:</strong> `+ data.vote_average + `</li>
                <li class="list-group-item"><strong>Director:</strong> `+ data.casts.crew[0].name + `</li>
                <li class="list-group-item"><strong>Writer:</strong> `+ data.casts.crew[1].name + `</li>
                <li class="list-group-item"><strong>Actors:</strong> `+ data.casts.cast[0].name + ', ' + data.casts.cast[1].name + ', ' + data.casts.cast[2].name + `</li>
              </ul>
            </div>
          </div>
          <div class="row">
            <div class="well">
              <h3>Plot</h3>`+ data.overview + `<hr>
              <a href="http://imdb.com/title/${data.imdb_id}" target="_blank" class="btn btn-primary">View IMDB</a>
              <a href="#" class="btn btn-primary">Go Back</a>        
            </div>
          </div>
        `)
  }



  function handleError(jqXHR, textStatus, errorThrown, ) {
    console.log(textStatus, errorThrown);

  }

}



