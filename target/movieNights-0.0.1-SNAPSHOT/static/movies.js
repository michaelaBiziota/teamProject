jQuery(Load);
function Load($) {


    //MAIN PAGE
    let URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=200";
    $.ajax({

        url: URL,
        success: handleResponse,
        error: handleError
    });

    function handleResponse(data) {
        $("#movies").html("");
        console.log(data);
        for (i = 0; i < 20; i++) {
            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/"+data.results[i].id+"'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>"+data.results[i].title+"</h5></div></div>");   
          
        
        }
       
      $("#popular").attr("class","nav-item active");
    };


    function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);

    };
    
    //MOST POPULAR
   $("#popular").on("click",function(){
     let URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=200";
    $.ajax({

        url: URL,
        success: handleResponse,
        error: handleError
    });

    function handleResponse(data) {
        $("#movies").html("");
        console.log(data);
        for (i = 0; i < 20; i++) {
            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/"+data.results[i].id+"'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>"+data.results[i].title+"</h5></div></div>"); 
            
        };
        $("#basicExampleNav ul li").removeClass("active");
        $("#popular").attr("class","nav-bar active");   
        }
        function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);

    };
       
    

   });
   
   
//SEARCH BOX
$("#searchForm").on("keyup",function (event) {
    event.preventDefault();
    let $userInput=$("#searchText").val();
    let URL = "https://api.themoviedb.org/3/search/movie?api_key=e58e3961f5be7e510894dc736fee6937&query="+$userInput;
    $.ajax({

        url: URL,
        success: handleResponse,
        error: handleError
    });

    function handleResponse(data) {
        $("#movies").html("");
        console.log(data);
        for (i = 0; i < 20; i++) {
            if(data.results[i].poster_path!==null){
            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/"+data.results[i].id+"'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>"+data.results[i].title+"</h5></div></div>");   
          
        }
        }
    }
    function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);

    };
});

 //GENRES ΣΕ ΣΧΕΣΗ ΜΕ ΤΟ ACTIVE
 
 $(".genres").on("click",function () {
     var genre;
     if($(this).attr("id")==="action"){
         genre=28;}
     else if($(this).attr("id")==="animation"){
         genre=16;
     }else if($(this).attr("id")==="comedy"){
         genre=35;
     }else if($(this).attr("id")==="drama"){
         genre=18;
     }else if($(this).attr("id")==="romance"){
         genre=10749;
     }else if($(this).attr("id")==="mystery"){
         genre=9648;
     }else if($(this).attr("id")==="science"){
         genre=878;
      }else if($(this).attr("id")==="thriller"){
         genre=53;}
     //checkarei to active    
     if($(".active").attr("id")==="popular"){
     URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres="+genre+"&page=1&vote_count.gte=200";
    }else if($(".active").attr("id")==="toprated"){
      URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=2100&with_genres="+genre;  
    }//TODO
    $.ajax({

        url: URL,
        success: handleResponse,
        error: handleError
    });
    

    function handleResponse(data) {
        $("#movies").html("");
        console.log(data);
        for (i = 0; i < 20; i++) {
            if(data.results[i].poster_path!==null){
            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/"+data.results[i].id+"'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>"+data.results[i].title+"</h5></div></div>");   
          
        }
        }
    };
    function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);

    }; 
});

        //TOP RATED
$("#toprated").on("click",function(){
     let URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=5000";
    $.ajax({

        url: URL,
        success: handleResponse,
        error: handleError
    });

    function handleResponse(data) {
        $("#movies").html("");
        console.log(data);
        for (i = 0; i < 20; i++) {
            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/"+data.results[i].id+"'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>"+data.results[i].title+"</h5></div></div>");   
          
        
        }
       $("#basicExampleNav ul li").removeClass("active"); 
       $("#toprated").attr("class","nav-item active");
    };
   function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);

    };  
 });
 
 
 }