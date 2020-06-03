<#macro page>
    <#include "security.ftlh">
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>FlexStarter</title>


        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/static/style.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    </head>
    <body>
    <div class="container">
        <div class="header row">

            <div class="col-sm-3 col-lg-3 test_kek">
                there logo
            </div>
            <div class="col-sm-5 col-lg-5">
                there anything else
            </div>
            <div class="col-sm-4 col-lg-4">
               socials
            </div>

        </div>
        <div class="row main">
            <div class="col-md-4 col-lg-3 col-sm-4 main__nav">
                <ul class="main__list">
                    <li class="main__list_elem">
                        <a href="/user/profile" class="main__link">Profile</a>
                    </li>
                    <li class="main__list_elem">
                        <a href="/main" class="main__link">Main page</a>
                    </li>

                    <li class="main__list_elem">
                        <a href="user-messages/${currentUserId}" class="main__link"> my Funds</a>
                    </li>
                    <li class="main__list_elem">
                        <a href="/donate" class="main__link">Donate</a>
                    </li>

                </ul>
            </div>
            <div class="col-md-8 col-lg-9 col-sm-8 main__content">
                <#nested>
            </div>
        </div>


    </div>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>