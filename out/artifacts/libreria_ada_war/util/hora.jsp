<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="util/hora.css">
</head>
<body>
<div class="hora-container">
        <div class="hora" id="hora"></div>
    <script>
        function actualizarHora() {
            var fecha = new Date();
            var hora = fecha.toLocaleDateString('es-ES', {dateStyle: "short"}) + " " + fecha.toLocaleTimeString('es-ES');
            document.getElementById("hora").innerHTML = hora;
        }
        setInterval(actualizarHora, 1000);
    </script>
</div>
</body>