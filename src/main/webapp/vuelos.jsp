
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
            <div class="card" style="z">
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-3">
                            <input type="text" id="origenFld" placeholder="Origen" class="form-control">
                        </div>
                        <div class="col-sm-3">
                            <input type="text" id="destinoFld" placeholder="Destino" class="form-control">
                        </div>
                        <div class="col-sm-2">
                            <input type="date" id="idaFld" class="form-control">
                        </div>
                        <div class="col-sm-2">
                            <input type="date" id="regresoFld" class="form-control">
                        </div>
                        <div class="col-sm-2">
                            <button class="btn btn-success" id="buscarBtn" style="width: 100%">Buscar</button>
                        </div>
                    </div>
                    <div class="row" style="padding-top: 10px">
                        <div class="col-sm-12">
                            <table id="tabla" class="table table-striped">
                                <thead class="bg-warning" style="text-align: center">
                                    <th>Origen</th>
                                    <th>Destino</th>
                                    <th>Fecha de Salida</th>
                                    <th>Fecha de Regreso</th>
                                    <th>Precio</th>
                                    <th>Asientos</th>
                                    <th>X</th>
                                </thead>
                                <tbody id="vuelosTable" class="bg-white">

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="modal fade" id="asientosMenu">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content" style="display: inline-table">
                                        <div class="modal-header" style="display: inline">
                                            <h2>Seleccionar Asientos</h2>
                                        </div>
                                        <div class="modal-body">

                                                <table class="table table-bordered table-sm" id="asientosTable">
                                                    <thead id="asientosTableHead">

                                                    </thead>
                                                    <tbody id="asientosTableBody">

                                                    </tbody>
                                                </table>
                                            <h3><label id="PrecioLabel" class></label></h3>

                                        </div>
                                        <div class="modal-footer col-sm-12" style="display: inline">
                                            <input class="btn btn-outline-secondary" style="background-color: lightgray" value="Cancelar" data-dismiss="modal">
                                            <input class="btn btn-success" style="background-color: lightgreen" id="confirmAsientosBtn" value="Confirmar" data-dismiss="modal">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <footer>
        <jsp:include page="footer.jsp" />
    </footer>
    <script>
        // VARIABLES --
        var ws;
        var asientos = [];
        var vuelos = [];
        var vuelo = null;
        //----------------
        
        function init(){
            initWS();
            $("#confirmBtn").on("click", ()=>{
                seleccionarAsientos();
                $("#asientosMenu").modal("show");
            });
            
            $(document).on('hide.bs.modal', '#asientosMenu', function() {
                asientos = [];
                $("#asientosTableHead").html("");
                $("#asientosTableBody").html("");
                $("#PrecioLabel").html("");
            });
            
            $("#buscarBtn").on("click", ()=>{
                console.log($("#idaFld").val());
            });
            
            $("#confirmAsientosBtn").on("click", ()=>{
                    confirmarCompra();
            });
            
        }
        
        function seleccionarAsientos(num){
            if(!userActive){
                alert("Para comprar un vuelo debe loguearse o registrarse primero.")
            }
            else{
                $("#asientosMenu").modal("show");
                
                vuelo = vuelos[num];
                var c = 0;
                $("#asientosTableHead").append("<th style='text-align: center;'>X</th>");
                for(var i = 1; i<vuelo.horario.avion.tipoavion.columnas+1;i++){
                    $("#asientosTableHead").append(
                        "<th style='text-align: center;'>"+i+"</th>"    
                        );
                }
                for(var i = 0; i<vuelo.horario.avion.tipoavion.filas; i++){
                    var tr = $("<tr />");
                    tr.append("<td style='text-align: center;'>"+(i+1)+"</td>");
                    for(var j = 0; j<vuelo.horario.avion.tipoavion.columnas; j++){ //Dibuja las celdas de asientos
                        tr.append(
                            '<td style="text-align: center;">'+
                            '<div class="form-check form-check-inline">'+
                                '<input class="form-check-input" style="display: none" name="asientos" type="checkbox" id="checkbox'+c+'" value="'+(i+1)+','+(j+1)+'">'+
                                '<label class="btn btn-lg btn-outline-secondary" id=checklabel'+c+' for="checkbox'+c+'" onclick="changeBox(checkbox'+c+', checklabel'+c+', '+vuelo.horario.precio+')"></label>'+
                            '</div>'+
                            '</td>'
                            );
                        c++;
                    }
                    $("#asientosTableBody").append(tr);

                    if(i < vuelo.horario.avion.tipoavion.filas-1 && (i+1) % 3 === 0){ // Dibuja una linea en blanco para el pasillo
                        var tr = $("<tr />");
                        for(var j = 0; j<12;j++){
                            tr.append(
                                "<td style='text-align: center;'>-</td>"    
                                );
                        }
                        $("#asientosTableBody").append(tr);
                    }

                }
                //Seccion sin terminar :C
                var x = $("input[name='asientos']"); // Asientos NO disponibles
                for(var i = 0; i < x.length; i++){
                    if(x[i].value === '7,5'){
                        $("#checklabel"+x[i].id.match(/\d+/)[0]).addClass("btn-danger");
                        $("#"+x[i].id).add("disabled");
                    }
                }
                
                
            }
        }
        
        function changeBox(check, label, price){
            
            if(asientos.includes(check)){
                asientos.splice(asientos.indexOf(check), 1);
                $("#"+label.id).removeClass("btn-success");
                //$('#'+check.id).prop("checked", "");
            }
            else{
                asientos.push(check);
                $("#"+label.id).addClass("btn-success");
                /*
                if(asientos.length < 2){
                    asientos.push(check);
                    $("#"+label.id).addClass("btn-success");
                }
                else{
                    var a = $("input[name='asientos']:checked")[checklist.length-1].id;
                    $('#'+a).prop("checked", "");
                    alert('Seleccione un maximo de ' + 2 + ' Asientos');
                }
                */
                
            }
            
            $("#PrecioLabel").html(
                "Precio total por "+asientos.length+" asientos es: <br> "+price*asientos.length
                );
        }
        
        function confirmarCompra(){
            let valores = [];
            valores.push(JSON.stringify({metodo: "insert"}));
            
            valores.push(JSON.stringify({precio: vuelo.horario.precio*asientos.length, cliente: {username: user}, vuelo: vuelo}));
            
            for(var i = 0; i < asientos.length; i++){
                var fc = asientos[i].value.split(',');
                valores.push(JSON.stringify({id: 1, fila:fc[0], columna:fc[1]}));
            }
            ws.send(JSON.stringify(valores));
        }
        
        function initWS(){
            ws = new WebSocket("ws://localhost:8084/aerolinea/vuelos");
            ws.onopen = function(event){
                let a = [];
                a.push(JSON.stringify({"metodo": "selectAll"}));
                console.log(JSON.stringify({"metodo": "selectAll"}))
                console.log(a)
                ws.send(JSON.stringify(a));
            };
            ws.onclose = function(event){
            };
            ws.onmessage = function(event){
                console.log(JSON.parse(event.data));
                var data = JSON.parse(event.data);
                switch(data[0].metodo){
                    case "selectAll":
                        vuelos = data.slice(1);
                        listVuelos();
                        break;
                    case "insert":
                        location.reload();
                        break;
                        
                }
            };
        }
        
        function listVuelos(){
            var c = 0;
            vuelos.forEach( v => {
                var tr = $("<tr style='text-align: center' />");
                tr.append("<td>"+v.horario.ruta.origen+"</td>");
                tr.append("<td>"+v.horario.ruta.destino+"</td>");
                tr.append("<td>"+v.ida+"</td>");
                if(v.regreso == null){
                    tr.append("<td>Sin Regreso</td>");
                }
                else{
                    tr.append("<td>"+v.regreso+"</td>");
                }
                tr.append("<td>"+v.horario.precio+"</td>");
                tr.append("<td>"+v.horario.avion.tipoavion.filas * v.horario.avion.tipoavion.columnas+"</td>");
                tr.append("<td><button class='btn btn-sm btn-secondary' onclick='seleccionarAsientos("+c+")'>comprar</button></td>");
                $("#vuelosTable").append(tr);
                c++;
            });
            
            $('#tabla').DataTable({
                searching: false,
                lengthMenu: [5, 10, 20, 30],
                language: {
                    "url": "css/Spanish.json"
                }
            });
        }
        
        
        init();
        
    </script>
</html>
