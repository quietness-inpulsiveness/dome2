function foo(){
    var arr=new Array();
    var inputs=document.getElementsByTagName("input");
    for(var i=0;i<inputs.length;i++){
        var input=inputs[i];
        if(input.type=="checkbox" && input.checked==true){
            arr.push(input.value);
        }
    }
    window.location.href="T_userServlet?type=del&idlist="+arr;
}