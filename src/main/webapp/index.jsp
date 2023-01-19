<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Совунья</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<header class="panel">
    <div class="header">
        <h1>Ри Аркадий, P32081</h1>
        <h2>Вариант 21981</h2>
    </div>
    <div class="meme" hidden>
        <img class="pic" src="img/meme-img.png" height="100" width="180">
    </div>
</header>

<div class="main">
    <div class="task">
        <canvas id="example" width="280" height="280" style="border:1px solid #000000;"></canvas>
        <script><%@ include file="js/graph.js"%></script>
    </div>
    <div class="panel">
        <form method="post" id="form">
            <div class="check_box_group">
                <h2>X:</h2>
                <p><input type="radio" name="x" value="-3" checked> -3 </p>
                <p><input type="radio" name="x" value="-2"> -2 </p>
                <p><input type="radio" name="x" value="-1"> -1 </p>
                <p><input type="radio" name="x" value="0"> 0 </p>
                <p><input type="radio" name="x" value="1"> 1 </p>
                <p><input type="radio" name="x" value="2"> 2 </p>
                <p><input type="radio" name="x" value="3"> 3 </p>
                <p><input type="radio" name="x" value="4"> 4 </p>
                <p><input type="radio" name="x" value="5"> 5 </p>
            </div>
            <div class="text_field">
                <h2>Y:</h2>
                <input type="text" id="input_Y" name="y" placeholder="[-3;5]" maxlength="6" required>
                <p id="y-warning" hidden>Data must be in the range [-3;5]</p>
            </div>
            <div class="button_group">
                <h2>R:</h2>
                <button type="button" id="r1" class="r_button active" name="r" value="1">1</button>
                <button type="button" id="r2" class="r_button" name="r" value="1.5">1.5</button>
                <button type="button" id="r3" class="r_button" name="r" value="2">2</button>
                <button type="button" id="r4" class="r_button" name="r" value="2.5">2.5</button>
                <button type="button" id="r5" class="r_button" name="r" value="3">3</button>
                <input id="buf" name="r" hidden value="1">
            </div>
            <div class="service_button">
                <input type="submit" id="submit" class="button" value="Submit">
                <button type="button" class="button" id="clear">Clear</button>
            </div>
        </form>
    </div>
    <div id="table_block" class="panel">
        <table id="result-table">
            <tr>
                <td>X</td>
                <td>Y</td>
                <td>R</td>
                <td>Result</td>
                <td>Attempt time</td>
                <td>Processing time</td>
            </tr>
            <tr>
                <jsp:include page="table.jsp"/>
            </tr>
        </table>
    </div>
</div>

</body>

<script src="js/jquery-3.6.3.js"></script>
<script src="js/table.js"></script>
<script src="js/validator.js"></script>
<script src="js/meme.js"></script>
<srcipt src="js/graph.js"></srcipt>
</html>