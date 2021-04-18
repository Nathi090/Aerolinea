
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolínea</title>
         <jsp:include page="header.jsp" />
    </head>
    <body>
        
<!--        <div class="container">
        <form class="form-inline">
  <div class="form-group">
    <label for="exampleInputName2">Name</label>
    <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">Email</label>
    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
  </div>
  <button type="submit" class="btn btn-default">Send invitation</button>
</form>
        </div>-->
        
        
        <div  style="height:70px">
            <div>Agregar un nuevo horario</div>
            <div class="input-group" style=" width: 300px">                                            
                <input type="text" ID="datebox" Class="form-control" value="Seleccione la ruta" readonly>
                <div class="input-group-btn">
                    <button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
                        <span class="caret"></span>
                    </button>
                    <ul id="demolist" class="dropdown-menu">
                        
                    </ul>
                </div>
            </div>
                <a>Día</a><input id = "dia" style="width: 200px" type="text" >
                <a>Hora de salida</a><input id = "hora_sal" style="width: 200px" type="text" >
                <a>Hora de llegada</a><input id = "hora_lleg" style="width: 200px" type="text" >
                <a>Precio</a><input id = "precio" style="width: 200px" type="text" >
            <button id = "guarda_horario" type="button" class="btn btn-dark">Guardar</button>
        
        
        </div>
        
<!--         <div style= "display: block; overflow: auto;">
                <table id="tabla" class="table table-secondary table-scroll">
                    <thead >
                      <tr class="bg-secondary text-white">
                            <th>Día</th>
                            <th>Horad de Salida</th>
                            <th>Hora de llegada</th>
                            <th>Precio</th>
                            <th>Edición</th>
                            
                        </tr>
                    </thead>
                        <tbody>
                    
                    </tbody>
                </table>
                 </div>-->

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
        
        function cargar (usuario){
                var ws1 = new WebSocket("ws://localhost:8084/aerolinea/horario");

                ws1.onopen = function(event){
                    ws1.send(SON.stringify(JSON.stringify(usuario));
                }
                ws1.onclose = function(event){
                }

                ws1.onmessage = function(event){ 
                    
                    }
                }
            }
            
         function loaded(){
                $("#guarda_horario").on("click", () => {
                    if (validate()) {
                        var horario = {
                        type: "Horario",
                        dia $("#dia").val(),
                        hora $("#clave").val()  
                        };
                        //addLogout();
                        cargar(usuario);
                        
                    }
                    return false;
                });

            }
        
        function leer_e_imprimir(rutas){
            var db_rutas = $("#demolist");
            rutas.forEach( (ruta)=>{rowRuta(db_rutas, ruta);} );
            
            $('#demolist li').on('click', function(){
                $('#datebox').val($(this).text());
            });
        }

        function rowRuta(tabla_rutas, ruta){
            var db =$("<li/>")
                db.html("<a href='#' class='dropdown-item'>"+
                       ruta.id + " - " + 
                       ruta.origen + " - " +
                       ruta.destino + "</a>");
                tabla_rutas.append(db);        
        }
    
        
      $(loaded)

</script>        
    </body>
        <jsp:include page="footer.jsp" />
</html>
