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
        var page = 1;
        $("#movies").html("");
        $("#pages").html("");
        console.log(data);
        for (i = 0; i < 20; i++) {
            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
            $("#pages").html("<span class='mx-2 mb-5 page arrows' id='leftarrow'>&laquo;</span> <span class='mx-2 page pagenumbers' id='p1'>1</span><span  class='text-secondary mx-2 page pagenumbers' id='p2'>2</span><span  class='text-secondary mx-2 page pagenumbers' id='p3'>3</span><span  class='text-secondary mx-2 page pagenumbers' id='p4'>4</span><span  class='text-secondary mx-2 page pagenumbers' id='p5'>5</span><span  class='mx-2 mb-5 page arrows' id='rightarrow'>&raquo;</span>");

        }
        //MAIN PAGE-PAGINATION
        $(".pagenumbers").on("click", function () {

            $(".pagenumbers").addClass("text-secondary");
            $(this).removeClass("text-secondary");
            page = parseInt($(this).html());
            let URL;
            if ($(this).attr("id") === "p1") {
                URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=200";
            } else if ($(this).attr("id") === "p2") {
                URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=2&vote_count.gte=200";
            } else if ($(this).attr("id") === "p3") {
                URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=3&vote_count.gte=200";
            } else if ($(this).attr("id") === "p4") {
                URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=4&vote_count.gte=200";
            } else if ($(this).attr("id") === "p5") {
                URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=5&vote_count.gte=200";
            }
            $.ajax({

                url: URL,
                success: handleResponse,
                error: handleError
            });

            function handleResponse(data) {

                $("#movies").html("");
                console.log(data);
                for (i = 0; i < 20; i++) {
                    $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                }
            }
        });
        $(".arrows").on("click", function () {

            let URL;
            $(".pagenumbers").addClass("text-secondary");



            if ($(this).attr("id") === "leftarrow") {
                if (page !== 1) {
                    page -= 1;
                }

                URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=200";

            } else if ($(this).attr("id") === "rightarrow") {
                if (page !== 5) {
                    page += 1;
                }
                URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=200";

            }
            $("#p" + page).removeClass("text-secondary");
            $.ajax({

                url: URL,
                success: handleResponse,
                error: handleError
            });



            function handleResponse(data) {
                $("#movies").html("");
                console.log(data);
                for (i = 0; i < 20; i++) {
                    $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                }
            }

        });
        $("#popular").attr("class", "nav-item active");
    }
    ;



    function handleError(jqXHR, textStatus, errorThrown) {
        console.log(textStatus, errorThrown);

    }
    ;

    //MOST POPULAR
    $("#popular").on("click", function () {
        let URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=200";
        $.ajax({

            url: URL,
            success: handleResponse,
            error: handleError
        });

        function handleResponse(data) {
            var page = 1;
            $("#pages").html("");
            $("#movies").html("");
            console.log(data);
            for (i = 0; i < 20; i++) {
                $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                $("#pages").html("<span class='mx-2 mb-5 page arrows' id='leftarrow'>&laquo;</span> <span class='mx-2 page pagenumbers' id='p1'>1</span><span class='text-secondary mx-2 page pagenumbers' id='p2'>2</span><span class='text-secondary mx-2 page pagenumbers' id='p3'>3</span><span class='text-secondary mx-2 page pagenumbers' id='p4'>4</span><span class='text-secondary mx-2 page pagenumbers' id='p5'>5</span><span class='mx-2 mb-5 page arrows' id='rightarrow'>&raquo;</span>");
            }
            ;
            //POPULAR-PAGINATION
            $(".pagenumbers").on("click", function () {

                $(".pagenumbers").addClass("text-secondary");
                $(this).removeClass("text-secondary");
                page = parseInt($(this).html());
                let URL;
                if ($(this).attr("id") === "p1") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=200";
                } else if ($(this).attr("id") === "p2") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=2&vote_count.gte=200";
                } else if ($(this).attr("id") === "p3") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=3&vote_count.gte=200";
                } else if ($(this).attr("id") === "p4") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=4&vote_count.gte=200";
                } else if ($(this).attr("id") === "p5") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=5&vote_count.gte=200";
                }
                $.ajax({

                    url: URL,
                    success: handleResponse,
                    error: handleError
                });

                function handleResponse(data) {

                    $("#movies").html("");
                    console.log(data);
                    for (i = 0; i < 20; i++) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                    }
                }
            });
            $(".arrows").on("click", function () {

                let URL;
                $(".pagenumbers").addClass("text-secondary");



                if ($(this).attr("id") === "leftarrow") {
                    if (page !== 1) {
                        page -= 1;
                    }

                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=200";

                } else if ($(this).attr("id") === "rightarrow") {
                    if (page !== 5) {
                        page += 1;
                    }
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=200";

                }
                $("#p" + page).removeClass("text-secondary");
                $.ajax({

                    url: URL,
                    success: handleResponse,
                    error: handleError
                });



                function handleResponse(data) {
                    $("#movies").html("");
                    console.log(data);
                    for (i = 0; i < 20; i++) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                    }
                }

            });
            $("#basicExampleNav ul li").removeClass("active");
            $("#popular").attr("class", "nav-bar active");
        }
        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);

        }
        ;



    });


//SEARCH BOX
    $("#searchText").on("keyup", function (event) {
        event.preventDefault();
        let $userInput = $("#searchText").val();
        let URL = "https://api.themoviedb.org/3/search/movie?api_key=e58e3961f5be7e510894dc736fee6937&query=" + $userInput;
        $.ajax({

            url: URL,
            success: handleResponse,
            error: handleError
        });

        function handleResponse(data) {
            $("#movies").html("");
            console.log(data);
            for (i = 0; i < 20; i++) {
                if (data.results[i].poster_path !== null) {
                    $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");

                }
            }
        }
        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);

        }
        ;
    });

    //GENRES ΣΕ ΣΧΕΣΗ ΜΕ ΤΟ ACTIVE

    $(".genres").on("click", function () {
        var genre;
        if ($(this).attr("id") === "action") {
            genre = 28;
        } else if ($(this).attr("id") === "animation") {
            genre = 16;
        } else if ($(this).attr("id") === "comedy") {
            genre = 35;
        } else if ($(this).attr("id") === "drama") {
            genre = 18;
        } else if ($(this).attr("id") === "romance") {
            genre = 10749;
        } else if ($(this).attr("id") === "mystery") {
            genre = 9648;
        } else if ($(this).attr("id") === "science") {
            genre = 878;
        } else if ($(this).attr("id") === "thriller") {
            genre = 53;
        }
        //checkarei to active
        //POPULAR-GENRE
        if ($(".active").attr("id") === "popular") {
            let URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres=" + genre + "&page=1&vote_count.gte=200";
            $.ajax({

                url: URL,
                success: handleResponse,
                error: handleError
            });


            function handleResponse(data) {
                var page = 1;
                $("#pages").html("");
                $("#movies").html("");
                console.log(data);
                for (i = 0; i < 20; i++) {
                    if (data.results[i].poster_path !== null) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                        $("#pages").html("<span class='mx-2 mb-5 page arrows' id='leftarrow'>&laquo;</span> <span class='mx-2 page pagenumbers' id='p1'>1</span><span class='text-secondary mx-2 page pagenumbers' id='p2'>2</span><span class='text-secondary mx-2 page pagenumbers' id='p3'>3</span><span class='text-secondary mx-2 page pagenumbers' id='p4'>4</span><span class='text-secondary mx-2 page pagenumbers' id='p5'>5</span><span class='mx-2 mb-5 page arrows' id='rightarrow'>&raquo;</span>");
                    }
                }
                //GENRES POPULAR-PAGINATION
                $(".pagenumbers").on("click", function () {

                    $(".pagenumbers").addClass("text-secondary");
                    $(this).removeClass("text-secondary");
                    page = parseInt($(this).html());

                    let URL;
                    if ($(this).attr("id") === "p1") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres=" + genre + "&page=1&vote_count.gte=200";
                    } else if ($(this).attr("id") === "p2") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres=" + genre + "&page=2&vote_count.gte=200";
                    } else if ($(this).attr("id") === "p3") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres=" + genre + "&page=3&vote_count.gte=200";
                    } else if ($(this).attr("id") === "p4") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres=" + genre + "&page=4&vote_count.gte=200";
                    } else if ($(this).attr("id") === "p5") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres=" + genre + "&page=5&vote_count.gte=200";
                    }
                    $.ajax({

                        url: URL,
                        success: handleResponse,
                        error: handleError
                    });

                    function handleResponse(data) {

                        $("#movies").html("");
                        console.log(data);
                        for (i = 0; i < 20; i++) {
                            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                        }
                    }
                });
                $(".arrows").on("click", function () {

                    let URL;
                    $(".pagenumbers").addClass("text-secondary");



                    if ($(this).attr("id") === "leftarrow") {
                        if (page !== 1) {
                            page -= 1;
                        }

                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres=" + genre + "&page=" + page + "&vote_count.gte=200";

                    } else if ($(this).attr("id") === "rightarrow") {
                        if (page !== 5) {
                            page += 1;
                        }
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=popularity.desc&include_adult=false&with_genres=" + genre + "&page=" + page + "&vote_count.gte=200";

                    }
                    $("#p" + page).removeClass("text-secondary");
                    $.ajax({

                        url: URL,
                        success: handleResponse,
                        error: handleError
                    });



                    function handleResponse(data) {
                        $("#movies").html("");
                        console.log(data);
                        for (i = 0; i < 20; i++) {
                            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                        }
                    }

                });
            }
            ;
        }
        //TOPRATED-GENRE
        else if ($(".active").attr("id") === "toprated") {
            let  URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=2100&with_genres=" + genre;
            $.ajax({

                url: URL,
                success: handleResponse,
                error: handleError
            });


            function handleResponse(data) {
                var page = 1;
                $("#pages").html("");
                $("#movies").html("");
                console.log(data);
                for (i = 0; i < 20; i++) {
                    if (data.results[i].poster_path !== null) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                        $("#pages").html("<span class='mx-2 mb-5 page arrows' id='leftarrow'>&laquo;</span> <span class='mx-2 page pagenumbers' id='p1'>1</span><span class='text-secondary mx-2 page pagenumbers' id='p2'>2</span><span class='text-secondary mx-2 page pagenumbers' id='p3'>3</span><span class='text-secondary mx-2 page pagenumbers' id='p4'>4</span><span class='text-secondary mx-2 page pagenumbers' id='p5'>5</span><span class='mx-2 mb-5 page arrows' id='rightarrow'>&raquo;</span>");
                    }
                }
                //GENRES TOPRATED-PAGINATION
                $(".pagenumbers").on("click", function () {

                    $(".pagenumbers").addClass("text-secondary");
                    $(this).removeClass("text-secondary");
                    page = parseInt($(this).html());

                    let URL;
                    if ($(this).attr("id") === "p1") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=2100&with_genres=" + genre;
                    } else if ($(this).attr("id") === "p2") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=2&vote_count.gte=2100&with_genres=" + genre;
                    } else if ($(this).attr("id") === "p3") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=3&vote_count.gte=2100&with_genres=" + genre;
                    } else if ($(this).attr("id") === "p4") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=4&vote_count.gte=2100&with_genres=" + genre;
                    } else if ($(this).attr("id") === "p5") {
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=5&vote_count.gte=2100&with_genres=" + genre;
                    }
                    $.ajax({

                        url: URL,
                        success: handleResponse,
                        error: handleError
                    });

                    function handleResponse(data) {

                        $("#movies").html("");
                        console.log(data);
                        for (i = 0; i < 20; i++) {
                            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                        }
                    }
                });
                $(".arrows").on("click", function () {

                    let URL;
                    $(".pagenumbers").addClass("text-secondary");



                    if ($(this).attr("id") === "leftarrow") {
                        if (page !== 1) {
                            page -= 1;
                        }

                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=2100&with_genres=" + genre;

                    } else if ($(this).attr("id") === "rightarrow") {
                        if (page !== 5) {
                            page += 1;
                        }
                        URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=2100&with_genres=" + genre;

                    }
                    $("#p" + page).removeClass("text-secondary");
                    $.ajax({

                        url: URL,
                        success: handleResponse,
                        error: handleError
                    });



                    function handleResponse(data) {
                        $("#movies").html("");
                        console.log(data);
                        for (i = 0; i < 20; i++) {
                            $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                        }
                    }

                });
            }
            ;
        }
        //INTHEATERS-GENRE
        else if ($(".active").attr("id") === "intheaters") {
            let  URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=50&with_genres=" + genre;
            $.ajax({

                url: URL,
                success: handleResponse,
                error: handleError
            });


            function handleResponse(data) {
                var page = 1;
                $("#pages").html("");
                $("#movies").html("");
                console.log(data);
                for (i = 0; i < 20; i++) {
                    if (data.results[i].poster_path !== null) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");

                    }
                }

            }
            ;
        }


        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);

        }
        ;
    });

    //TOP RATED
    $("#toprated").on("click", function () {
        let URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=5000";
        $.ajax({

            url: URL,
            success: handleResponse,
            error: handleError
        });

        function handleResponse(data) {
            var page = 1;
            $("#pages").html("");
            $("#movies").html("");
            console.log(data);
            for (i = 0; i < 20; i++) {
                $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                $("#pages").html("<span class='mx-2 mb-5 page arrows' id='leftarrow'>&laquo;</span> <span class='mx-2 page pagenumbers' id='p1'>1</span><span class='text-secondary mx-2 page pagenumbers' id='p2'>2</span><span class='text-secondary mx-2 page pagenumbers' id='p3'>3</span><span class='text-secondary mx-2 page pagenumbers' id='p4'>4</span><span class='text-secondary mx-2 page pagenumbers' id='p5'>5</span><span class='mx-2 mb-5 page arrows' id='rightarrow'>&raquo;</span>");

            }

            //TOP RATED-PAGINATION
            $(".pagenumbers").on("click", function () {

                $(".pagenumbers").addClass("text-secondary");
                $(this).removeClass("text-secondary");
                page = parseInt($(this).html());
                let URL;
                if ($(this).attr("id") === "p1") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=5000";
                } else if ($(this).attr("id") === "p2") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=2&vote_count.gte=5000";
                } else if ($(this).attr("id") === "p3") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=3&vote_count.gte=5000";
                } else if ($(this).attr("id") === "p4") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=4&vote_count.gte=5000";
                } else if ($(this).attr("id") === "p5") {
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=5&vote_count.gte=5000";
                }
                $.ajax({

                    url: URL,
                    success: handleResponse,
                    error: handleError
                });

                function handleResponse(data) {

                    $("#movies").html("");
                    console.log(data);
                    for (i = 0; i < 20; i++) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                    }
                }
            });
            $(".arrows").on("click", function () {

                let URL;
                $(".pagenumbers").addClass("text-secondary");



                if ($(this).attr("id") === "leftarrow") {
                    if (page !== 1) {
                        page -= 1;
                    }

                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=5000";

                } else if ($(this).attr("id") === "rightarrow") {
                    if (page !== 5) {
                        page += 1;
                    }
                    URL = "https://api.themoviedb.org/3/discover/movie?api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=5000";

                }
                $("#p" + page).removeClass("text-secondary");
                $.ajax({

                    url: URL,
                    success: handleResponse,
                    error: handleError
                });



                function handleResponse(data) {
                    $("#movies").html("");
                    console.log(data);
                    for (i = 0; i < 20; i++) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                    }
                }

            });
            $("#basicExampleNav ul li").removeClass("active");
            $("#toprated").attr("class", "nav-item active");
        }
        ;
        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);

        }
        ;
    });

    //IN THEATERS
    $("#intheaters").on("click", function () {
        let URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=10";
        $.ajax({

            url: URL,
            success: handleResponse,
            error: handleError
        });

        function handleResponse(data) {
            var page = 1;
            $("#pages").html("");
            $("#movies").html("");
            console.log(data);
            for (i = 0; i < 20; i++) {
                $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                $("#pages").html("<span class='mx-2 mb-5 page arrows' id='leftarrow'>&laquo;</span> <span class='mx-2 page pagenumbers' id='p1'>1</span><span class='text-secondary mx-2 page pagenumbers' id='p2'>2</span><span class='text-secondary mx-2 page pagenumbers' id='p3'>3</span><span class='text-secondary mx-2 page pagenumbers' id='p4'>4</span><span class='text-secondary mx-2 page pagenumbers' id='p5'>5</span><span class='mx-2 mb-5 page arrows' id='rightarrow'>&raquo;</span>");

            }
            //IN THEATERS-PAGINATION
            $(".pagenumbers").on("click", function () {

                $(".pagenumbers").addClass("text-secondary");
                $(this).removeClass("text-secondary");
                page = parseInt($(this).html());
                let URL;
                if ($(this).attr("id") === "p1") {
                    URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=1&vote_count.gte=10";
                } else if ($(this).attr("id") === "p2") {
                    URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=2&vote_count.gte=10";
                } else if ($(this).attr("id") === "p3") {
                    URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=3&vote_count.gte=10";
                } else if ($(this).attr("id") === "p4") {
                    URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=4&vote_count.gte=10";
                } else if ($(this).attr("id") === "p5") {
                    URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=5&vote_count.gte=10";
                }
                $.ajax({

                    url: URL,
                    success: handleResponse,
                    error: handleError
                });

                function handleResponse(data) {

                    $("#movies").html("");
                    console.log(data);
                    for (i = 0; i < 20; i++) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                    }
                }
            });
            $(".arrows").on("click", function () {

                let URL;
                $(".pagenumbers").addClass("text-secondary");



                if ($(this).attr("id") === "leftarrow") {
                    if (page !== 1) {
                        page -= 1;
                    }

                    URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=10";

                } else if ($(this).attr("id") === "rightarrow") {
                    if (page !== 5) {
                        page += 1;
                    }
                    URL = "https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2019-06-01&api_key=e58e3961f5be7e510894dc736fee6937&language=en-US&sort_by=vote_average.desc&include_adult=false&include_video=false&page=" + page + "&vote_count.gte=10";

                }
                $("#p" + page).removeClass("text-secondary");
                $.ajax({

                    url: URL,
                    success: handleResponse,
                    error: handleError
                });



                function handleResponse(data) {
                    $("#movies").html("");
                    console.log(data);
                    for (i = 0; i < 20; i++) {
                        $("#movies").append("<div class='col-md-3'><div class=' text-center'><a href='getMovie/" + data.results[i].id + "'><img src='https://image.tmdb.org/t/p/w300" + data.results[i].poster_path + "'></a><h5 id='moviestitle'>" + data.results[i].title + "</h5></div></div>");
                    }
                }

            });
            $("#basicExampleNav ul li").removeClass("active");
            $("#intheaters").attr("class", "nav-item active");
        }
        ;
        function handleError(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);

        }
        ;
    });


}