window.onload=function  () {	
	var btn1=document.getElementById("button1");
	var txt3=document.getElementById("text3");
	var txt4=document.getElementById("text4");
	var txta=document.getElementById("aihao");
	var btn3=document.getElementById("button3");
	
	btn3.disabled=true
	btn1.onclick=function  () {		
		alert("请输入要修改的信息")
		txt3.disabled=false
		txt4.disabled=false
		txta.disabled=false
		btn1.disabled=true
		btn3.disabled=false
	}
	
	txt3.onblur=function(){
		if(txt3.value!="男"&&txt3.value!="女")	{
			alert("输入错误，请重新输入！");
			}
	}
}