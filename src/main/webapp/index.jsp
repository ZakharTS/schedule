<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="icon" href="img/icon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="img/icon.ico" type="image/x-icon">
        <title>Средство просмотра расписания БРГТУ</title>
        <link rel="stylesheet" href="CSS/style.css" type="text/css">
        <link rel="stylesheet" href="CSS/fonts.css">
    </head>
    <body>
    <div id="wrap">
        <header>
            <div style="text-align: center;">
                <div class = "logo">
                    <a href="index.jsp"> <img class = "logo" src="img/logo.svg" alt="Сайт БРГТУ"> </a>
                </div>
                <div class="special">
                    <p> Средство просмотра расписания</p>
                </div>
            </div>
            <hr>
        </header>
        <form action="form-handler" method="POST" enctype="multipart/form-data">
            <input type="file" id="xl-table" name="xl-table" accept="xl/*"><br>
            <input type="text" id="name" name="name"><br><br>
            <input type="submit" value="Submit"><br>
        </form>
    </div>
    <footer>
        <hr>
        <div class="links">
            <a href="https://github.com/ZakharTS/schedule"> <img style="max-height: 3em; width: auto" src="img/GitHub-Mark-120px-plus.png" alt="Github проекта "></a>
        </div>
        <div style="text-align: center;"><p>2022 ZakharTS all rights reserved.</p></div>
    </footer>
    </body>
</html>