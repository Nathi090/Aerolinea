
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://momentjs.com/downloads/moment.js"></script>
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
        
        <div class="container">
            <div class="card">
                <div class="card-body">
            <div>Agregar un nuevo horario</div>
            <div class="input-group" style=" width: 300px">                                            
                <input type="text" ID="datebox" class="form-control" value="Seleccione la ruta" readonly>
                <div class="input-group-btn">
                    <button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
                        <span class="caret"></span>
                    </button>
                    <ul id="demolist" class="dropdown-menu">
                        
                    </ul>
                </div>
            </div>
            <div>
                <a>Día</a><input id = "dia" style="width: 200px" type="date" >
                <a>Hora de salida</a><input id = "hora_sal"  style="width: 200px" type="time" >
                <a>Hora de llegada</a><input id = "hora_lleg"  style="width: 200px" type="time" >
                <a>Precio</a><input id = "precio" style="width: 200px" type="text" >
            <button id = "guarda_horario" type="button" class="btn btn-dark">Guardar</button>
             </div>
        
        
                            </div>

                        </div>

                    </div>


    <script>
       
        document.getElementById('dia').valueAsDate = new Date();
        var salida;
        var rutasTodas = [];
        var selectedRuta= '';
        $('#hora_sal').on("input", function(){
            //console.log(moment($('#hora_sal').val(), 'hh:mm').add(1, 'hours').format('hh:mm'));
            console.log(rutasTodas);
            console.log(parseInt(salida[0]));
            rutasTodas.forEach( (ruta)=>{
                    console.log(":VV");
                    if (ruta.id === parseInt(salida[0]))
                        selectedRuta = ruta;
            } );
            console.log(selectedRuta) ;
                $("#hora_lleg").val(moment($('#hora_sal').val(), 'hh:mm').add(selectedRuta.duracion, 'hours').format('hh:mm'));
            });
        
        
        var ws = new WebSocket("ws://localhost:8084/aerolinea/rutas");
        let rutas;

        ws.onopen = function(event){
            ws.send(JSON.stringify( ['{"metodo": "Leer"}'] ));
        }
        ws.onclose = function(event){
        }

        ws.onmessage = function(event){
            rutasTodas = JSON.parse(event.data);
            leer_e_imprimir(rutasTodas);  
        }
        
        function cargar (horario){
                var ws1 = new WebSocket("ws://localhost:8084/aerolinea/horarios");

                ws1.onopen = function(event){
                    ws1.send(JSON.stringify(horario));
                }
                ws1.onclose = function(event){
                }

                ws1.onmessage = function(event){ 
                    
                    }
                }
            
            
         function loaded(){
                $("#guarda_horario").on("click", () => {
                    if (validate()) {
                        var now = Date.parse($('#hora_lleg'));
                        var horario = {
                        type: "Horario",
                        dia: $("#dia").val(),
                        hora:  $('#hora_lleg').val(),
                        precio: $("#precio").val(),
                        ruta: selectedRuta
                        };
                        console.log(horario)
                        cargar(horario);
                        location.reload();
                        
                    }
                    return false;
                });

            }
        
        function leer_e_imprimir(rutas){
            var db_rutas = $("#demolist");
            rutas.forEach( (ruta)=>{rowRuta(db_rutas, ruta);} );
            
            $('#demolist li').on('click', function(){ 
                salida = $(this).text();
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
    
            function validate() {
                var val = true;
                if ($("#datebox").val() === 'Seleccione la ruta') {
                    $("#datebox").css("background-color", "pink");
                    val = false;
                }
                
                if (!$("#hora_sal").val()) {
                    $("#hora_sal").css("background-color", "pink");
                    val = false;
                }
                if (!$("#hora_lleg").val()) {
                    $("#hora_lleg").css("background-color", "pink");
                    val = false;
                }
                if ($("#precio").val() === '') {
                    $("#precio").css("background-color", "pink");
                    val = false;
                }
                return val;
            }
        
    $(loaded);

</script>        
    </body>
        <jsp:include page="footer.jsp" />
</html>
