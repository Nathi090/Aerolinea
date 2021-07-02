
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolínea</title>
         <jsp:include page="header.jsp" />
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-body">
        <div  style="height:70px;">
            <div>Agregar un nuevo avión</div>
                <a>Año</a><input id = "anno" style="width: 200px" type="number" >
                <a>Modelo</a><input id = "modelo" style="width: 200px" type="text" >
                <a>Marca</a><input id = "marca" style="width: 200px" type="text" >
                
                
                
            <button type="button" id="GuardaAvion" class="btn btn-dark">Guardar</button>
        
        </div>
                    </div>
                </div>
        </div>
    <script>
        
            function cargar(avion){
            var ws = new WebSocket("ws://localhost:8084/aerolinea/aviones");

            ws.onopen = function(event){
                ws.send(JSON.stringify(avion));
            }
            ws.onclose = function(event){
            }

           ws.onmessage = function(event){ 
                    
            }}
    
    
            function loaded(){
                $("#GuardaAvion").on("click", () => {
                    if (validate()) {                        
                        console.log("Debería funcionar")
                        var avion = {
                        metodo: "Guardar",
                        type: "Avion",
                        anno: $("#anno").val(),
                        modelo: $("#modelo").val(),
                        marca: $("#marca").val()
                        };
                        cargar(JSON.stringify(avion));
                        location.reload();
                    }
                    return false;
                });

            }

            function validate() {
                var val = true;
                if ($("#anno").val() === '') {
                    $("#anno").css("background-color", "pink");
                    val = false;
                }
                if ($("#modelo").val() === '') {
                    $("#modelo").css("background-color", "pink");
                    val = false;
                }
                if ($("#marca").val() === '') {
                    $("#marca").css("background-color", "pink");
                    val = false;
                }
                return val;
            }
            
            $(loaded);
    </script>
        
    </body>
        <jsp:include page="footer.jsp" />
</html>
