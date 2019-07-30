<%-- 
    Document   : payPalSuccess
    Created on : 28 Ιουλ 2019, 9:35:29 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>🎬 Payment Successful</title>
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
              integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/about.css">
    </head>
    <body>
        <div class="text-center">
            <p><h2 class="my-5 text-white">Your payment was successful!</h2></p>
            <div class="col-xs-12 my-3">
              <img src="${pageContext.request.contextPath}/static/pictures/thankyou.png" class="img-fluid" id="thankyou">
            </div>
        </div>
        <div class="text-center">
          <a href="http://localhost:8080/movieNights/movies" class="btn btn-primary fa fa-arrow-left mx-1 my-1 text-center" title="Back to movieNights"> Back to Movie Nights</a>
        </div>
    </body>

</html>
