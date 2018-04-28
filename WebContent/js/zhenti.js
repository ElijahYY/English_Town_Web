window.onload=function  () {
	
	   	var str
		var c=0
    	var t
   
	    function two_char(n) {
            return n >= 10 ? n : "0" + n;
        }
        function time_fun() {
            var sec=0;
           t= setInterval(function () {
                sec++;
                var date = new Date(0, 0)
                date.setSeconds(sec);
                var h = date.getHours(), m = date.getMinutes(), s = date.getSeconds();
                document.getElementById("mytime").innerText = two_char(h) + ":" + two_char(m) + ":" + two_char(s);
            }, 1000);
        }
        
       
        
      
	var shijian=document.getElementById("mytime")
	var jieshu=document.getElementsByClassName("btn btn-default btn-success btn-block");
	var jiexi=document.getElementsByTagName("img")
	var kaishi=document.getElementsByClassName("btn btn-default btn-warning btn-block");
	
    shijian.readOnly="true"
   
	kaishi[0].onclick=function(){
		
		kaishi[0].disabled="true"
		time_fun()

	}
		jieshu[0].onclick=function  () {
		clearTimeout(t);
		jiexi[jiexi.length-1].style.display="block";
		var daan=document.getElementsByTagName("select");
		str=daan[0].value.toString()+daan[1].value+daan[2].value+daan[3].value+daan[4].value
		alert("你的答案是"+str)
		daan[0].disabled="true"
		daan[1].disabled="true"
		daan[2].disabled="true"
		daan[3].disabled="true"
		daan[4].disabled="true"
		jieshu[0].disabled="true"
		alert("所用时间："+shijian.innerHTML)
        	//存储笔记
        	alert(biji.value)
        	//结束计时
        	
		
	}
	
	
    
}