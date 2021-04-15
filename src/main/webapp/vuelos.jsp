
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
            <div class="row">
                <div class="col-sm-12">
                    <table class="table table-striped">
                        <thead class="bg-warning">
                            <th>Origen</th>
                            <th>Destino</th>
                            <th>Fecha de salida</th>
                            <th>Fecha de regreso</th>
                            <th>Precio</th>
                            <th>Asientos</th>
                            <th>X</th>
                        </thead>
                        <tbody class="bg-white">
                            
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
    </body>
    <footer>
        <jsp:include page="footer.jsp" />
    </footer>
    <script>
        var asientos = [];
        function init(){
            $("#confirmBtn").on("click", ()=>{
                $("#asientosMenu").modal("show");
                
                var c = 0;
                $("#asientosTableHead").append("<th style='text-align: center;'>X</th>");
                for(var i = 1; i<12;i++){
                    $("#asientosTableHead").append(
                        "<th style='text-align: center;'>"+i+"</th>"    
                        );
                }
                for(var i = 0; i<9; i++){
                    var tr = $("<tr />");
                    tr.append("<td style='text-align: center;'>"+(i+1)+"</td>");
                    for(var j = 0; j<11; j++){
                        tr.append(
                            '<td style="text-align: center;">'+
                            '<div class="form-check form-check-inline">'+
                                '<input class="form-check-input" style="display: none" name="asientos" type="checkbox" id="checkbox'+c+'" value="'+(i+1)+','+(j+1)+'">'+
                                '<label class="btn btn-lg btn-outline-secondary" id=checklabel'+c+' for="checkbox'+c+'" onclick="changeBox(checkbox'+c+', checklabel'+c+')"></label>'+
                            '</div>'+
                            '</td>'
                            );
                        c++;
                    }
                    $("#asientosTableBody").append(tr);
                    
                    if(i < 9-1 && (i+1) % 3 === 0){
                        var tr = $("<tr />");
                        for(var j = 0; j<12;j++){
                            tr.append(
                                "<td style='text-align: center;'>-</td>"    
                                );
                        }
                        $("#asientosTableBody").append(tr);
                    }
                    
                }
                
                $("input[name='asientos']").on("change", ()=>{
                    console.log(12321412412);
                });
                
                var x = $("input[name='asientos']");
                for(var i = 0; i < x.length; i++){
                    if(x[i].value === '7,5'){
                        $("#checklabel"+x[i].id.match(/\d+/)[0]).addClass("btn-danger");
                        $("#"+x[i].id).add("disabled");
                    }
                }
                
                $("#confirmAsientosBtn").on("click", ()=>{
                    $("#asientosMenu").modal("hide");
                });
            });
            
            $(document).on('hide.bs.modal', '#asientosMenu', function() {
                $("#asientosTableHead").html("");
                $("#asientosTableBody").html("");
            });
        }
        
        function changeBox(check, label){
            var checklist = $("input[name='asientos']:checked").toArray();
            
            if(asientos.includes(check)){
                asientos.splice(asientos.indexOf(check), 1);
                $("#"+label.id).removeClass("btn-success");
                //$('#'+check.id).prop("checked", "");
            }
            else{
                if(asientos.length < 2){
                    asientos.push(check);
                    $("#"+label.id).addClass("btn-success");
                }
                else{
                    var a = $("input[name='asientos']:checked")[checklist.length-1].id;
                    $('#'+a).prop("checked", "");
                    alert('Seleccione un maximo de ' + 2 + ' Asientos');
                }
            }
            console.log("CheckList");
            for(var i = 0; i < checklist.length; i++){
                console.log(checklist[i].value);
            }
            console.log("Asientos");
            for(var i = 0; i < asientos.length; i++){
                console.log(asientos[i].value);
            }
        }
        
        function test(){
            var ws = new WebSocket("ws://localhost:8084/aerolinea/vuelos");
            ws.onopen = function(event){
                
                ws.send(JSON.stringify({"poio": "en papas", "papas": "fritas"}));
            }
            ws.onclose = function(event){
            }
            ws.onmessage = function(event){
                console.log(1111);
            }
        }
        
        init();
        test();
        
    </script>
</html>
