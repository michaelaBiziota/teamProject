<%-- 
    Document   : about
    Created on : 26 Ιουλ 2019, 11:38:31 μμ
    Author     : thodo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="static/about.css">
    </head>
    <body>
        <div class="container">
            <!-- MovieNights Logo -->
            <div class="col-md-4 col-xs-12 mt-3">
                <a href="${pageContext.request.contextPath}/movies">
                    <img src="static/pictures/mn.png" class="mx-5 img-fluid" id="movienightsprof" title="Home">
                </a>
            </div>
            <!-- End -->

            <div class="container text-white">
                <div>
                    <h1 class="text-center my-3">What is Movie Nights?</h1>
                </div>
                <div class="par">
                    <p>This is a place for discovering movies, made with love by a couple of friends.</p>

                    <p>We adore movies but finding great ones to watch was usually a hassle. We had been searching for a nicely
                        designed and simple interface for movie browsing yet we couldn’t find one… So we made one ourselves.</p>

                    <p>Movie Nights started out as a passion project and continues to improve thanks to wonderful people like
                        yourself who give us invaluable feedback on a daily basis.</p>
                </div>
                <div>
                    <h2 class="text-center my-2">Contact us</h2>
                    <p class="text-center par">Please email us at
                        <a href=#>movienightsproject@gmail.com</a> for any specific information you might need
                    </p>
                </div>
                <div>
                    <h2 class="text-center my-3">Help us Grow</h2>
                </div>
                <p class="text-center par">Show us some love if you like what we're doing!</p>
                <form method="post" action="paypal/make/payment">
                    <input type="number" name="sum">Give me your money
                    <input type="submit">
                    
                </form>
            </div>

        </div>
    </body>
</html>
