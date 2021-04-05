
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
                                        <div id="asientosTable"></div>
                                    </div>
                                </div>
                                <div class="modal-footer" style="display: inline">
                                    <input class="btn btn-outline-secondary" style="background-color: lightgray" value="Cancelar" data-dismiss="modal">
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
                for(var i = 0; i<11;i++){
                    $("#asientosTable").append(i);
                }
                $("#asientosTable").append("<br>");
                for(var i = 0; i<9; i++){
                    for(var j = 0; j<11; j++){
                        $("#asientosTable").append(
                            '<div class="form-check form-check-inline">'+
                                '<input class="form-check-input" name="asientos" type="checkbox" id="inlineCheckbox'+c+'" value="'+c+'">'+
                                '<label class="form-check-label" for="inlineCheckbox'+c+'"></label>'+
                            '</div>'
                            );
                        c++;
                    }
                    $("#asientosTable").append("<br>");
                    if((i+1) % 3 === 0){
                        $("#asientosTable").append("<br>");
                    }
                }

                $("input[name='asientos']").on("change", ()=>{
                    
                    var size = $("input[name='asientos']:checked").length;
                    console.log($("input[name='asientos']:checked"));
                    if(size > 2){
                        var a = $("input[name='asientos']:checked")[size-1].id;
                        $('#'+a).prop("checked", "");
                        alert('Select maximum ' + 2 + ' Levels!');
                    }
                });
            });
            
            
        }
        init();
        
    </script>
</html>
