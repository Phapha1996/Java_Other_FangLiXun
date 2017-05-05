function check(){
	var pres = document.getElementsByName("pre");
	for(var i=0;i<pres.length;i++){
		if(pres[i].checked==true)
			alert(pres[i].value);
	}
	return false;
}