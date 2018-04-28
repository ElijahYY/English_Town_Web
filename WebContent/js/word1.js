
window.onload=function  () {
	alert("开始")
	var newword =document.getElementsByTagName("td") 
	var num=newword.length/2;
	alert(num);
	var yiji=document.getElementsByClassName("btn btn-success")
	var weiji=document.getElementsByClassName("btn btn-danger")
	var kaishi=document.getElementsByClassName("btn btn-primary btn-lg")
	var word=document.getElementsByClassName("modal-body")
	
	kaishi[0].onclick=function  () {
		alert("开始复习")
		var j=0
			yiji[0].onclick=function  () {
				word[0].innerHTML= newword[j].innerHTML
				//实现改变单词属性
				alert("0")
				j+=2
				if(j/2==num){
					alert("打卡成功")
					//实现打卡记录添加
				}
			}
			weiji[0].onclick=function  () {
				word[0].innerHTML= newword[j].innerHTML
				//实现改变单词属性
				alert("1")
				j+=2
				if(j/2==num){
					alert("打卡成功")
					//实现打卡记录添加
				}
				
			}
		
		
		
		
		
		
	}
	
	
}	
