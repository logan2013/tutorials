(function(){var window=this;var a=this;var b=function(c,e){var d=parseFloat(c);return isNaN(d)||1<d||0>d?e:d},f=function(c,e){var d=parseInt(c,10);return isNaN(d)?e:d},g=/^([\w-]+\.)*([\w-]{2,})(\:[0-9]+)?$/,h=function(c,e){if(!c)return e;var d=c.match(g);return d?d[0]:e};var k=b("0.02",0),l=b("0",0);var m=b("0",0),n=b("0.001",0),p=f("1500",1500),q=b("0.01",0),r=b("1",0),t=b("0.5",0),u=b("",.001),v=f("",200),aa=b("0.01",0),ba=/^true$/.test("")?
!0:!1,ca=b("0",0),da=b("0.01",0),ea=b("0.1",0),fa=b("0.01",0),ga=b("1",0),ha=b("",.001),ia=b("0",0),ja=b("0.1",0),ka=b("0.0001",0),w=f("101",0),la=f("100",0),x=b("0.05",
0),ma=b("0",0),na=b("0.1",0),oa=b("0.001",0),pa=b("0.05",0),qa=b("1",0),ra=b("1",0),sa=b("0.01",0),ta=b("0.05",0),ua=b("0",0),va=b("0",0),wa=b("0",
0),xa=b("0.5",0),ya=b("0.00001",0),za=b("0.5",0),Aa=b("0.5",0),Ba=b("0.95",0),Ca=b("0",0),Da=b("0.05",0),Ea=b("0.05",0),Fa=b("0.001",0),Ga=b("0",0),y=b("0.01",
0),Ha=b("0",0),Ia=b("0",0);var Ja=/^true$/.test("true")?!0:!1;var z=function(c,e){if(!(1E-4>Math.random())){var d=Math.random();if(d<e){var Ka=window;try{var I=new Uint32Array(1);Ka.crypto.getRandomValues(I);d=I[0]/65536/65536}catch(Ma){d=Math.random()}return c[Math.floor(d*c.length)]}}return null};var A=function(){return a.googletag||(a.googletag={})},B=function(c,e){var d=A();d.hasOwnProperty(c)||(d[c]=e)};var C={};C["#1#"]=h("","pagead2.googlesyndication.com");C["#2#"]=h("","pubads.g.doubleclick.net");C["#3#"]=h("","securepubads.g.doubleclick.net");C["#6#"]=function(c){try{for(var e=null;e!=c;e=c,c=c.parent)switch(c.location.protocol){case "https:":return!0;case "http:":case "file:":return!1}}catch(d){}return!0}(window);C["#7#"]=k;C["#10#"]=m;C["#11#"]=n;C["#13#"]=p;C["#16#"]=q;C["#17#"]=r;C["#18#"]=t;C["#20#"]=l;C["#23#"]=u;
C["#24#"]=v;C["#27#"]=aa;C["#28#"]=ca;C["#29#"]=da;C["#31#"]=ea;C["#33#"]=h("","pagead2.googlesyndication.com");C["#34#"]=ga;C["#36#"]=ba;C["#37#"]=fa;C["#38#"]=ha;C["#39#"]="";C["#40#"]=ia;C["#45#"]=ja;C["#46#"]=Ja;C["#47#"]=ka;C["#49#"]=(new Date).getTime();C["#53#"]="";C["#54#"]=ma;C["#55#"]=na;C["#56#"]=oa;C["#57#"]=pa;C["#58#"]=qa;C["#59#"]=ra;C["#60#"]=sa;C["#61#"]=ta;C["#62#"]=ua;C["#63#"]=va;C["#64#"]=wa;C["#65#"]=xa;
C["#66#"]=ya;C["#67#"]=za;C["#68#"]=Aa;C["#69#"]=Ba;C["#70#"]=Ca;C["#71#"]=Da;C["#72#"]=Ea;C["#73#"]=Fa;C["#74#"]=Ga;C["#75#"]="";C["#76#"]="";C["#77#"]=Ha;B("_vars_",C);C["#78#"]=Ia;B("getVersion",function(){return"95"});var La={};var D="",E="",F=!1,G=C["#46#"]&&!C["#6#"],D=G?"http:":"https:",E=G?C["#2#"]:C["#3#"],H=A(),J=(H.fifWin||window).document;B("cmd",[]);
if(H.evalScripts)H.evalScripts();else{var K=J.currentScript,L=la||"95",M="",N,O="partner.googleadservices.com",P=La["#6#"]||A()._vars_["#6#"]?"https:":"http:";w&&x&&(N=z([w,L],2*x),N==w?C["#53#"]="108809094":N==L&&(C["#53#"]="108809093",M="?v="+w));if(!N&&y){var Q=z("108809156 108809157 108809158 133303540 133303541 133303542".split(" "),6*y);if(Q)switch(C["#75#"]=Q,Q){case "133303541":F=!0;break;case "133303542":M="?v="+L,F=!0;case "108809157":"http:"==P&&K&&K.src&&0==K.src.indexOf("https:")&&(P=
"https:");O="www.googletagservices.com";break;case "108809158":P=D;O=E;break;case "108809156":M="?v="+L}}var R=P+"//"+O+"/gpt/pubads_impl_"+(N||L)+".js"+M;C["#76#"]=R;var S;if(S=F){var T=a.navigator&&a.navigator.userAgent||"",T=T.toLowerCase();S=-1!=T.indexOf("firefox/")||-1!=T.indexOf("chrome/")||-1!=T.indexOf("opr/")}var U=S;if(!("complete"==J.readyState||"loaded"==J.readyState||K&&K.async)){var V="gpt-impl-"+Math.random();try{var W='<script id="'+V+'" src="'+R+'">\x3c/script>';U&&(W+='<link rel="preconnect" href="'+
D+"//"+E+'">');J.write(W);H._syncTagged_=!0}catch(c){}J.getElementById(V)&&(H._loadStarted_=!0)}if(!H._loadStarted_){var X=J.createElement("script");X.src=R;X.async=!0;var Y=J.head||J.body||J.documentElement;Y.appendChild(X);if(U){var Z=J.createElement("link");Z.rel="preconnect";Z.href=D+"//"+E;Y.appendChild(Z)}H._loadStarted_=!0}};}).call(this.googletag&&googletag.fifWin?googletag.fifWin.parent:this)

