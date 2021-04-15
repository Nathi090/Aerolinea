
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolínea</title>
         <jsp:include page="header.jsp" />
         
    </head>
    <body>
        
         <div style= "display: block; overflow: auto;">
                <table class="table table-secondary table-scroll">
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
                        <tbody id="tabla_aviones">
                   
                    </tbody>
                </table>
                 </div>
        
        <script>
            
            var ws = new WebSocket("ws://localhost:8084/aerolinea/aviones");

            ws.onopen = function(event){
                ws.send("Enviar");
            }
            ws.onclose = function(event){
            }

            ws.onmessage = function(event){
                leer_e_imprimir(JSON.parse(event.data));  

            }

            
            function leer_e_imprimir(aviones){
                var tabla_aviones = $("#tabla_aviones");
                aviones.forEach( (avion)=>{rowAvion(tabla_aviones, avion);} );
            }
            
            function rowAvion(tabla_aviones, avion){
                var tr =$("<tr id = avion"+avion.id+ "/>");
                    tr.html("<td> "+avion.id+" </td>"+
                    "<td> "+avion.anno+" </td>"+
                    "<td> "+avion.modelo+" </td>"+
                    "<td> "+avion.marca+" </td>"+
                    "<td> "+avion.tipoavion.columnas * avion.tipoavion.filas+" </td>"+
                    "<td> "+avion.tipoavion.filas+" </td>"+
                    "<td> "+avion.tipoavion.columnas+" </td>");
                tabla_aviones.append(tr);        
            }
            
        </script>
        
        
    </body>    
    <jsp:include page="footer.jsp" />
</html>
