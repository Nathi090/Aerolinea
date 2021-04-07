
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolínea</title>
         <jsp:include page="header.jsp" />
    </head>
    <body>
        <div>
            <button id="confirmBtn" class="btn btn-success">Botoncin</button>
        </div>
        <div class="row">
                <div class="col-sm-12">
                    <div class="modal fade" id="asientosMenu">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header" style="display: inline">
                                    <h2>Seleccionar Asientos</h2>
                                </div>
                                <div class="modal-body">
                                    <div class="col-sm-12">
                                        <table class="table" id="asientosTable">
                                            <thead id="asientosTableHead">
                                                
                                            </thead>
                                            <tbody id="asientosTableBody">
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="modal-footer col-sm-12" style="display: inline">
                                    <input class="btn btn-outline-secondary" style="background-color: lightgray" value="Cancelar" data-dismiss="modal">
                                    <input class="btn btn-sm btn-success" style="background-color: lightgreen" id="confirmAsientosBtn" value="Confirmar" data-dismiss="modal">
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
        function init(){
            $("#confirmBtn").on("click", ()=>{
                $("#asientosMenu").modal("show");
                
                var c = 0;
                $("#asientosTableHead").append("<th>X</th>");
                for(var i = 1; i<12;i++){
                    $("#asientosTableHead").append(
                        "<th>"+i+"</th>"    
                        );
                }
                for(var i = 0; i<9; i++){
                    var tr = $("<tr />");
                    tr.append("<td>"+(i+1)+"</td>");
                    for(var j = 0; j<11; j++){
                        tr.append(
                            '<td>'+
                            '<div class="form-check form-check-inline">'+
                                '<input class="form-check-input" name="asientos" type="checkbox" id="inlineCheckbox'+c+'" value="'+(i+1)+','+(j+1)+'">'+
                                '<label class="form-check-label" for="inlineCheckbox'+c+'"></label>'+
                            '</div>'+
                            '</td>'
                            );
                        c++;
                    }
                    $("#asientosTableHead").append(tr);
                    /*
                    if((i+1) % 3 === 0){
                        $("#asientosTable").append("<br>");
                    }
                    */
                }

                $("input[name='asientos']").on("change", ()=>{
                    
                    var size = $("input[name='asientos']:checked").length;
                    console.log($("input[name='asientos']:checked"));
                    if(size > 2){
                        var a = $("input[name='asientos']:checked")[size-1].id;
                        $('#'+a).prop("checked", "");
                        alert('Seleccione un maximo de ' + 2 + ' Asientos');
                    }
                });
                
                $("#confirmAsientosBtn").on("click", ()=>{
                    var lista = $("input[name='asientos']:checked");
                    for(var i = 0; i < lista.length; i++){
                        console.log(lista[i].value);
                    }
                    $("#asientosMenu").modal("hide");
                });
            });
            
            $(document).on('hide.bs.modal', '#asientosMenu', function() {
                $("#asientosTableHead").html("");
                $("#asientosTableBody").html("");
            });
            
            
        }
        init();
        
    </script>
</html>
