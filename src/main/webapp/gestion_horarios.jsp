
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
        
        
        <div  style="height:70px;">
            <div>Agregar un nuevo horario</div>
            <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" data-target="rutas_bd" aria-haspopup="true" aria-expanded="false">
                Ruta
            </button>
            <div  id = "rutas_bd" class="dropdown-menu" aria-labelledby="dropdownMenuButton">
               <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Action</a>
                <!-- <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>-->
            </div>
        </div>
                <a>Día</a><input id = "dia" style="width: 200px" type="text" >
                <a>Hora de salida</a><input id = "hora_sal" style="width: 200px" type="text" >
                <a>Hora de llegada</a><input id = "hora_lleg" style="width: 200px" type="text" >
                <a>Precio</a><input id = "precio" style="width: 200px" type="text" >
            <button type="button" class="btn btn-dark">Guardar</button>
        
        
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
            //leer_e_imprimir(JSON.parse(event.data));  
        }
        
        function leer_e_imprimir(rutas){
            var db_rutas = $("#rutas_bd");
            rutas.forEach( (ruta)=>{rowRuta(db_rutas, ruta);} );
        }

        function rowRuta(tabla_rutas, ruta){
            var db =$("<a class='dropdown-item' href='#'>"+
                       ruta.id + " - " + 
                       ruta.origen + " - " +
                       ruta.destino + "</a>");
                tabla_rutas.append(db);        
            }
</script>        
    </body>
        <jsp:include page="footer.jsp" />
</html>
