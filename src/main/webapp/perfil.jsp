
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
                    <div style= "display: block; overflow: auto;">
                        <table class="table" id="tabla">
                            <thead >
                              <tr class="bg-secondary text-white">
                                    <th>Nombre</th>
                                    <th>Apellidos</th>
                                    <th>Correo</th>
                                    <th>Fecha de nacimiento</th>
                                    <th>Sexo</th>
                                    <th>Teléfono de trabajo</th>
                                    <th>Teléfono móvil</th>
                                    <th>Dirección</th>

                                </tr>
                            </thead>
                            <tbody id="tabla_perfil">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    <script>

        var ws = new WebSocket("ws://localhost:8084/aerolinea/perfil");

        ws.onopen = function(event){
            ws.send(JSON.stringify( '{"metodo": "Leer"}' ));
        }
        ws.onclose = function(event){
        }

        ws.onmessage = function(event){
            leer_e_imprimir(JSON.parse(event.data));  

        }


        function leer_e_imprimir(dato){
            var tabla_perfil = $("#tabla_perfil");
            console.log(dato)
            rowPerfil(tabla_perfil, dato);
            
        }

        function rowPerfil(tabla_perfil, dato){
            var tr =$("<tr id = 'usuario"+dato.id+ "'/>");
                tr.html("<td> "+dato.nombre+" </td>"+
                "<td> "+dato.apellidos+" </td>"+
                "<td> "+dato.correo+" </td>"+
                "<td> "+dato.fecNacimiento+" </td>"+
                "<td> "+dato.sexo +" </td>"+
                "<td> "+dato.telTrabajo+" </td>"+
                "<td> "+dato.telMovil+" </td>"+
                "<td> "+dato.direccion+" </td>");
            tabla_perfil.append(tr);        
        }

    </script>
        
        
    </body>    
    <jsp:include page="footer.jsp" />
</html>
