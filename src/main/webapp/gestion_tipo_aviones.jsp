
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolínea</title>
         <jsp:include page="header.jsp" />
         <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        
         <div style= "display: block; overflow: auto;">
                <table id="tabla1" class="table table-secondary table-scroll">
                    <thead >
                      <tr class="bg-secondary text-white">
                            <th>ID</th>
                            <th>Año</th>
                            <th>Modelo</th>
                            <th>Marca</th>
                            <th>Pasajeros</th>
                            <th>Filas</th>
                            <th>Asientos/filas</th>
                            
                        </tr>
                    </thead>
                        <tbody>
                   
                    </tbody>
                </table>
                 </div>
        
        <script>
            
             function loaded(){
                    cargar_tipo_aviones();
                }

              $(loaded);
            
            function cargar_tipo_aviones(){
               var ws = new WebSocket("ws://localhost:8084/aerolinea/tipo_aviones");
               
               ws.onopen = function(event){
                   ws.send("Bring it on");
               }
               ws.onclose = function(event){
                   console.log(event);
               }
               
               ws.onmessage = function(event){
                   var msg = JSON.parse(event.data);
                   console.log("AAAAAAAAAAAAAAAA")
                   console.log(msg)
                   
               }
            }
            
        </script>
        
        
    </body>    
    <jsp:include page="footer.jsp" />
</html>
