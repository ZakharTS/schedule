<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <form action="form-handler" method="POST" enctype="multipart/form-data">
            <input type="file" id="xl-table" name="xl-table" accept="xl/*"><br>
            <input type="text" id="name" name="name"><br><br>
            <input type="submit" value="Submit"><br>
        </form>
    </body>
</html>