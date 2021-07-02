
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolínea</title>
         <jsp:include page="header.jsp" />
    </head>
    <body>
<!--        <div  style="height:70px;">
            <div>Agregar nueva ruta</div>
                <a>ID</a><input style="width: 200px" type="text"  placeholder="Salida/Llegada">
                <a>Salida</a><input style="width: 200px" type="text" >
                <a>Llegada</a><input style="width: 200px" type="text" >
                <a>Duración</a><input style="width: 200px" type="text" >
            <button type="button" class="btn btn-dark">Guardar</button>
        
        
        </div>
        -->
        <div class="container">
            <div class="card">
                <div class="card-body">
        <div  style="height:70px;">
            <div>Agregar una nueva ruta</div>
            <div class="dropdown">
           
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
<!--                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>-->
            </div>
        </div>
                <a>Salida</a><input id="Salida" style="width: 200px" type="text" >
                <a>Llegada</a><input id="Llegada" style="width: 200px" type="text" >
                <a>Duración</a><input id="Duracion" style="width: 200px" type="number" >
            <button id="guarda_ruta" type="button" class="btn btn-dark">Guardar</button>
        
               

        </div>
         <div style= "display: block; overflow: auto;">
                <table  id="tabla_ta" class="table">
                    <thead >
                      <tr class="bg-secondary text-white">
                            <th>ID</th>
                            <th>Salida</th>
                            <th>Llegada</th>
                            <th>Duración</th>
                            
                        </tr>
                    </thead>
                        <tbody id="tabla_rutas">
                    
                    </tbody>
                </table>
                 </div>
                     </div>

                            </div>

                        </div>
        
        <script>
            
            var ws = new WebSocket("ws://localhost:8084/aerolinea/rutas");
            
            ws.onopen = function(event){
                ws.send(JSON.stringify( ['{"metodo": "Leer"}'] ));
            }
            ws.onclose = function(event){
            }

            ws.onmessage = function(event){
                console.log(JSON.parse(event.data));
                leer_e_imprimir(JSON.parse(event.data));  

            }

            
            function leer_e_imprimir(rutas){
                var tabla_rutas = $("#tabla_rutas");
                rutas.forEach( (ruta)=>{rowRuta(tabla_rutas, ruta);} );
                $('#tabla_ta').DataTable({
                lengthMenu: [10, 20, 30],
                language: {
                    "url": "css/Spanish.json"
                }
            });
            }
            
            function rowRuta(tabla_rutas, ruta){
                var tr =$("<tr id = 'ruta"+ruta.id+ "'/>");
                    tr.html("<td> "+ruta.id+" </td>"+
                    "<td> "+ruta.origen+" </td>"+
                    "<td> "+ruta.destino+" </td>"+
                    "<td> "+ruta.duracion+" </td>");
                    tabla_rutas.append(tr);        
                }
                
                
            function loaded(){
                $("#guarda_ruta").on("click", () => {
                    if (validate()) {                        
                        console.log("Debería funcionar")
                        var ruta = {
                        metodo: "Guardar",
                        type: "Ruta",
                        origen: $("#Salida").val(),
                        destino: $("#Llegada").val(),
                        duracion: $("#Duracion").val()
                        };
                        let lista = [];
                        lista.push(JSON.stringify(ruta));
                        
                        location.reload();
                        ws.send(JSON.stringify(lista));
                        
                    }
                    return false;
                });

            }

            function validate() {
                var val = true;
                if ($("#Salida").val() === '') {
                    $("#Salida").css("background-color", "pink");
                    val = false;
                }
                if ($("#Llegada").val() === '') {
                    $("#Llegada").css("background-color", "pink");
                    val = false;
                }
                if ($("#Duracion").val() === '') {
                    $("#Duracion").css("background-color", "pink");
                    val = false;
                }
                return val;
            }
            
            $(loaded);
            
        </script>
        
    </body>
        <jsp:include page="footer.jsp" />
</html>
