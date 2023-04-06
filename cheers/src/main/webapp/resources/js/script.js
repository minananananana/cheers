/**
 * 
 */
/*function writeSave(){
//script.js         
   if($("#writer").val()==''){
      alert("이름을 입력 하시요 ");
      $("#writer").focus();
      return false;
   }
   if($("#subject").val()==''){
      alert("글제목을 입력 하시요 ");
      $("#subject").focus();
      return false;
   }
   if($("#content").val()==''){
      alert("글내용을 입력 하시요 ");
      $("#content").focus();
      return false;
   }
   if($("#pw").val()==''){
      alert("암호을 입력 하시요 ");
      $("#pw").focus();
         return false;
      }
   
     return true;
   }//writeSave() end*/


/*function writeSave(){
   //alert("aaa")
   if(document.writeform.writer.value==""){
     alert("작성자를 입력하십시요.");
     document.writeform.writer.focus();
     return false;
   }
   if(document.writeform.subject.value==""){
     alert("제목을 입력하십시요.");
     document.writeform.subject.focus();
     return false;
   }
   
   if(document.writeform.content.value==""){
     alert("내용을 입력하십시요.");
     document.writeform.content.focus();
     return false;
   }
        
   if(document.writeform.pw.value==""){
     alert(" 비밀번호를 입력하십시요.");
     document.writeform.pw.focus();
     return false;
   }
   
   return true;
   //document.writeform.submit();
 }//writeSave()end
 */    
 //회원가입 입력 여부 체크
/* function writeSave(){
 //script.js         
   if($("#writer").val()==''){
      alert("이름을 입력 하시요 ");
      $("#writer").focus();
      return false;
   }
   if($("#subject").val()==''){
      alert("글제목을 입력 하시요 ");
      $("#subject").focus();
      return false;
   }
   if($("#content").val()==''){
      alert("글내용을 입력 하시요 ");
      $("#content").focus();
      return false;
   }
   if($("#pw").val()==''){
      alert("암호을 입력 하시요 ");
      $("#pw").focus();
         return false;
      }
   
     return true;
   }//writeSave() end

*/
/*function writeSave(){
   //alert("aaa")
   if(document.writeform.writer.value==""){
     alert("작성자를 입력하십시요.");
     document.writeform.writer.focus();
     return false;
   }
   if(document.writeform.subject.value==""){
     alert("제목을 입력하십시요.");
     document.writeform.subject.focus();
     return false;
   }
   
   if(document.writeform.content.value==""){
     alert("내용을 입력하십시요.");
     document.writeform.content.focus();
     return false;
   }
        
   if(document.writeform.pw.value==""){
     alert(" 비밀번호를 입력하십시요.");
     document.writeform.pw.focus();
     return false;
   }
   
   return true;
   //document.writeform.submit();
 }//writeSave()end
 */    
 
 
/*회원가입 입력 여부 체크*/
function memberCheck(){
	
    if($("#u_id").val() == ""){
       alert("ID를 입력하세요.");
       $("#u_id").focus();
       
       return false;
    }
    
     if($("#u_pw2").val() == ""){
       alert("비밀번호 확인을 입력하세요.");
       $("#u_pw2").focus();
       
       return false;
    }
    if($("#u_name").val() == ""){
       alert("이름을 입력하세요.");
       $("#u_name").focus();
       
       return false;
    }
     if($("#u_sex").val() == ""){
       alert("성별을 선택하세요.");
       $("#u_sex").focus();
       
       return false;
    }
 
    if($("#u_age").val() == ""){
       alert("생년월일을 입력하세요.");
       $("#u_age").focus();
       
       return false;
    }
      if($("#u_email").val() == ""){
       alert("이메일을 입력하세요.");
       $("#u_email").focus();
       
       return false;
    }
    if($("#u_tel").val() == "" || $("#u_tel2").val() == "" || $("#u_tel3").val() == ""){
       alert("전화번호를 정확히 입력하세요.");
       $("#u_tel").focus();
       
       return false;
    }
     if($("#u_zipcode").val() == ""){
       alert("우편번호를 입력하세요.");
       $("#u_zipcode").focus();
       
       return false;
    }
     if($("#u_addr2").val() == ""){
       alert("상세주소를 입력하세요.");
       $("#u_addr2").focus();
       
       return false;
    }
    
    return true;
 }//memberCheck()-end
 
function pwCheck(){
    if($("#u_pw").val() == ""){
       alert("비밀번호를 입력하세요.");
       $("#u_pw").focus();
       
       return false;
    }
    if($("#u_pw2").val() == ""){
       alert("비밀번호 확인을 입력하세요.");
       $("#u_pw2").focus();
       
       return false;
    }
    if($("#u_pw").val() != $("#u_pw2").val()){
       alert("비밀번호가 일치하지 않습니다.");
       $("#u_pw2").val("");
       $("#u_pw").val("");
       $("#u_pw").focus();
       
       return false;
    }
    
    return true;
    
 }//memberCheck()-end
 
 //이메일 체크
function emailCheck(){
      const inputCode = $(".mail-check-input").val();
      const resultMsg = $('#mail-check-warn');
   
     if(inputCode == code){
			resultMsg.html('인증번호가 일치합니다.');
			resultMsg.css('color','green');
			$('#mail-Check-Btn').attr('disabled',true);
			$('#userEmail1').attr('readonly',true);
			$('#userEmail2').attr('readonly',true);	
			$('#userEmail2').attr('onFocus', 'this.initialSelect = this.selectedIndex');
	        $('#userEmail2').attr('onChange', 'this.selectedIndex = this.initialSelect');
		}else{
			resultMsg.html('인증번호가 불일치 합니다. 다시 확인해주세요!.');
			resultMsg.css('color','red');
			$(".mail-check-input").focus();
		}
  
}