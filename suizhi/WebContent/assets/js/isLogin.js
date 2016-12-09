/**
 * Created by Administrator on 2016/11/5 0005.
 */
function isLogin(data){
    if(data=="nologin"){
        alert("请登录后再操作！")
        window.location.href="login.html";
    }
    return false;
}