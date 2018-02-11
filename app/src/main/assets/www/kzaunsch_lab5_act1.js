
//SER421
//Fall B 2017
//Karen Zaunscherb

//sets up variables for first three cities
var city1 = "London";
var city2 = "Phoenix";
var city3;
var city3Info = localStorage.getItem('city3Storage');
var viewCity3Info = JSON.parse(city3Info);
if (viewCity3Info != null){
    city3 = viewCity3Info;
}
var city1_arr = [];
var city2_arr = [];
var city3_arr = [];


main();
/*
 * Main Function which gets the initial two cities weather data
 */
function main(){
    getWeather(city1);
    getWeather(city2);
    if (city3 != undefined){
        getWeather(city3);
    }
}

/*
 * function gets the third city to show for weather
 */
function showCity(str){
    if (str == ""){
        document.getElementByID("tablecity3").innerHTML = "";
    }
    city3=str;
    addCityToStorage(city3);
    getWeather(city3);
    console.log(city3);
    return city3;
}

/*
 * function gets weather information from API, and posts it to appropriate place
 */
function getWeather(city) {
  var obj;
  var xhttp;    
  if (city == "") {
    console.log("Oops! There is no city!");
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        console.log(city);
        //console.log(this.responseText);
        obj = JSON.parse(this.responseText);
        console.log(obj);
        var tableData = "<tr><td>"+obj.name+", "+obj.sys.country+"</td>"+  // sets up tableData
            "<td>"+timeFormat(obj.dt)+"</td>" +
            "<td>"+ Math.round((obj.main.temp-273.15)*100)/100+"</td>"+
            "<td>"+ obj.main.humidity+"</td>"+
            "<td>"+obj.wind.speed+"</td>"+
            "<td>"+obj.clouds.all+"</td></tr>";
       if (city == city1){ //if the city is city1, it pushes it to city1 data's location and array
            var info = localStorage.getItem('cityStorage1');
            var viewInfo = JSON.parse(info);
           if (city1_arr.length == 0){
               document.getElementById("tablecity1").innerHTML=tableData;
               city1_arr.push(obj.name,obj.dt,obj.main.temp,obj.main.humidity,obj.wind.speed,obj.clouds.all,obj.sys.country); // saves array with information in order to use it for other data
               addToStorage(obj,1); // adds the info to local storage
           }
           else{
               document.getElementById("tablecity1").innerHTML=tableData;
               console.log("***"+viewInfo.name+viewInfo.dt);
               //console.log("!!"+city1_arr[0]);
                var tableData2 = "<tr><td>"+obj.name+", "+obj.sys.country+"</td>"+
                    "<td>"+(formatToHours(viewInfo.dt-obj.dt))+"</td>" +
                    "<td>"+ -((viewInfo.main.temp-obj.main.temp))+"</td>"+
                    "<td>"+ -(viewInfo.main.humidity-obj.main.humidity)+"</td>"+
                    "<td>"+ -(viewInfo.wind.speed-obj.wind.speed)+"</td>"+
                    "<td>"+ -(viewInfo.clouds.all-obj.clouds.all)+"</td></tr>";
                   document.getElementById("tablecity1b").innerHTML=tableData2;
               if(viewInfo.dt == city1_arr[1]){
                   console.log("content already exists.")
               }
               else{
                   city1_arr = [];
                   city1_arr.push(obj.name,obj.dt,obj.main.temp,obj.main.humidity,obj.wind.speed,obj.clouds.all,obj.sys.country); // saves array with information in order to use it for other data
                   addToStorage(obj,1); // updates storage if it isn't the same
                   //next refresh will show this information instead of previous
                   console.log("successfuly updated storage");  
               }
           }
       } 
       else if (city == city2){ // if city is city2, it pushes it to city2 data's location and array
           if (city2_arr.length == 0){
               document.getElementById("tablecity2").innerHTML=tableData;
               city2_arr.push(obj.name,obj.dt,obj.main.temp,obj.main.humidity,obj.wind.speed,obj.clouds.all,obj.sys.country);
               addToStorage(obj,2);
           }
           else{
               var info = localStorage.getItem('cityStorage2');
               var viewInfo = JSON.parse(info);
               document.getElementById("tablecity2").innerHTML=tableData;
               console.log("***"+viewInfo.name+viewInfo.dt);
               //console.log("!!"+city1_arr[0]);
                var tableData2 = "<tr><td>"+obj.name+", "+obj.sys.country+"</td>"+
                    "<td>"+(formatToHours(viewInfo.dt-obj.dt))+"</td>" +
                    "<td>"+ -((viewInfo.main.temp-obj.main.temp))+"</td>"+
                    "<td>"+ -(viewInfo.main.humidity-obj.main.humidity)+"</td>"+
                    "<td>"+ -(viewInfo.wind.speed-obj.wind.speed)+"</td>"+
                    "<td>"+ -(viewInfo.clouds.all-obj.clouds.all)+"</td></tr>";
                   document.getElementById("tablecity2b").innerHTML=tableData2;
               if(viewInfo.dt == city2_arr[1]){
                   console.log("content already exists.")
               }
               else{
                   city2_arr = [];
                   city2_arr.push(obj.name,obj.dt,obj.main.temp,obj.main.humidity,obj.wind.speed,obj.clouds.all,obj.sys.country);
               addToStorage(obj,2);
                   addToStorage(obj,2); // updates storage if it isn't the same
                   //next refresh will show this information instead of previous
                   console.log("successfuly updated storage");  
               }
           }
       }
       else if (city == city3){ // if city is city3, it pushes it to city3 data's location and array
            var info = localStorage.getItem('cityStorage3');
            var viewInfo = JSON.parse(info);

            if (viewInfo != null && city3_arr.length > 0){
                document.getElementById("tablecity3").innerHTML=tableData;
                
                var tableData2 = "<tr><td>"+obj.name+", "+obj.sys.country+"</td>"+
                    "<td>"+(formatToHours(viewInfo.dt-obj.dt))+"</td>" +
                    "<td>"+ -((viewInfo.main.temp-obj.main.temp))+"</td>"+
                    "<td>"+ -(viewInfo.main.humidity-obj.main.humidity)+"</td>"+
                    "<td>"+ -(viewInfo.wind.speed-obj.wind.speed)+"</td>"+
                    "<td>"+ -(viewInfo.clouds.all-obj.clouds.all)+"</td></tr>";
                   document.getElementById("tablecity3b").innerHTML=tableData2;
                    if(viewInfo.name == city3_arr[0] && viewInfo.dt == city3_arr[1]){
                        console.log("content already exists.")
                        }
                    else{
                        document.getElementById("tablecity3").innerHTML = tableData;
                       city3_arr = [];
                       city3_arr.push(obj.name,obj.dt,obj.main.temp,obj.main.humidity,obj.wind.speed,obj.clouds.all,obj.sys.country);
                   addToStorage(obj,3);
                       addToStorage(obj,3); // updates storage if it isn't the same
                       //next refresh will show this information instead of previous
                       console.log("successfuly updated storage");  
               }
           }
           else if(city3_arr.length == 0){
               document.getElementById("tablecity3").innerHTML=tableData; 
               city3_arr.push(obj.name,obj.dt,obj.main.temp,obj.main.humidity,obj.wind.speed,obj.clouds.all,obj.sys.country);
               addToStorage(obj,3);
           }
           else{
               document.getElementById("tablecity3").innerHTML=tableData; 
               city3_arr.push(obj.name,obj.dt,obj.main.temp,obj.main.humidity,obj.wind.speed,obj.clouds.all,obj.sys.country);
               addToStorage(obj,3);
           }
       }
      else{ // error statement if it isn't 1, 2, or 3
          this.status=403;
          document.getElementById("errors").innerHTML="Error! 403. Forbidden Resource can't be accessed";
          console.log("OOPS! I don't think yout meant to do that");
      }
      tempStats(city1_arr,city2_arr,city3_arr);
      humidityStats(city1_arr,city2_arr,city3_arr);
      weatherStats(city1_arr,city2_arr,city3_arr);
      saveWeather(city1_arr,city2_arr,city3_arr);
      //addToStorage(obj);
    }
      else if (this.status == 400){
        document.getElementById("errors").innerHTML= "<p> <b>Error 400:</b><br>Hmmm.... the requested content appears to be invalid!</p>"
          console.log("400 - Server understood request, but request content invalid");
      }
      else if (this.status == 401){
        document.getElementById("errors").innerHTML= "<p> <b>Error 401:</b><br>Oops! I don't think you were supposed to access this content...</p>"
          console.log("401 - Unauthorized access");
      }
      else if (this.status == 403){
        document.getElementById("errors").innerHTML= "<p> <b>Error 403:</b><br>This content is forbidden, like an undersea castle. Please try again!</p>"
          console.log("403 - forbidden resource can't be accessed");
      }
      else if (this.status == 404){
        document.getElementById("errors").innerHTML= "<p> <b>Error 404:</b><br>Roar! A tiger ate the page! It can't be found.</p>"
          console.log("404 - A tiger ate the page.");
      }
      else if (this.status == 500){
        document.getElementById("errors").innerHTML= "<p> <b>Error 500:</b><br>There are Gremlins in the Internal Server. (Internal Service Error).</p>"
          console.log("500 - internal service error");
      }
      else if (this.status == 503){
        document.getElementById("errors").innerHTML= "<p> <b>Error 503:</b><br>The service you've requested is unavailable."
          console.log("503 - service unavailable");
      }
      else{
          //console.log("Unknown Error! Must be gremlins.")
      }
  };
  xhttp.open("GET", "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=f9cd3610e9144f965638b5be216a0b1d", true);
  xhttp.send();
}


/*
 * This function finds out the different temperature statistics.
 * it takes an input for the temperatures, and calculates
 * the average and the hottest, with different formulas depending on if
 * there are 2 cities or 3 cities given.
 * Shows the results on the HTML page
 */

function tempStats(var1,var2,var3){
    var hottest;
    var avg;
    if (var3.length == 0){
        avg = Math.round((((var1[2]+var2[2])/2)-273.15)*100)/100;
        if (var1[2] >= var2[2]){
            hottest = var1[0];
            hotCountry = var1[6];
        }
        else{
            hottest = var2[0];
            hotCountry = var2[6];
        }
    }
    else{
        avg = Math.round((((var1[2]+var2[2]+var3[2])/3)-273.15)*100)/100;
        if((var1 >= var2) && (var1 >= var3)){
            hottest = var1[0];
            hotCountry = var1[6];
        }
        else if((var2[2]>= var1[2]) && (var2[2] >= var3[2])){
            hottest = var2[0];
            hotCountry = var2[6];
        }
        else{
            hottest = var3[0];
            hotCountry = var3[6];
        } 
    }
    document.getElementById("temperatureStats").innerHTML="The average temperature is "+avg+". The hottest place is "+hottest+", "+hotCountry+"."; 
}


/*
 * This function takes the humidity information from 2 or 3 variables. 
 * It finds the average humidity, as well as the most humid place.
 */
function humidityStats(var1,var2,var3){
    var mostHumid;
    var avg;
     if (var3.length == 0){
        avg = ((var1[3]+var2[3])/2);
        if (var1[3] >= var2[3]){
            mostHumid = var1[0];
            humidCountry=var1[6];
        }
        else{
            mostHumid = var2[0];
            humidCountry=var2[6];
        }
    }
    else{
        avg = ((var1[3]+var2[3]+var3[3])/3);
        if((var1 >= var2) && (var1 >= var3)){
            mostHumid = var1[0];
            humidCountry = var1[6];
        }
        else if((var2[3] >= var1[3]) && (var2[3] >= var3[3])){
            mostHumid = var2[0];
            humidCountry = var2[6];
        }
        else{
            mostHumid = var3[0];
            humidCountry = var3[6];
        } 
    }
    document.getElementById("humidityStats").innerHTML="The average humidity is "+ Math.round(avg*100)/100+". The most humid place is "+mostHumid+", "+humidCountry+".";    
}

/*
 * This function finds out the best and the worst weather
 * As weather is subjective, I made it fairly simple based off
 * of what I like as a scuba diver. First, the warmer the better
 * with warm weather means I don't have to wear my drysuit or wetsuit.
 * It then looks at humidity. It's a negative for several reasons.
 * Including that it makes it sticky to get out of the wetsuit.
 * As it's a percentage, it's divided by 10 to make it have better weight for preference.
 * Then it looks at the wind. Wind is bad because wind = waves.
 * It takes off points with any wind.
 * Then it looks at cloud coverage. This one, well I just like sun, so cloud 
 * coverage isn't the best. Again, it's divided by 10 for weight.
 */
function weatherStats(var1,var2,var3){
    var bestWeather;
    var bestCountry;
    var worstWeather;
    var worstCountry;
    var city1_points=var1[2]-(var1[3]/10)-var1[4]-(var1[5]/10);
    var city2_points=var2[2]-(var2[3]/10)-var2[4]-(var2[5]/10);
    var city3_points=var3[2]-(var3[3]/10)-var3[4]-(var3[5]/10);
    
    if (var3.length == 0){
        if (city1_points >= city2_points){
            bestWeather = var1[0];
            bestCountry = var1[6];
            worstWeather = var2[0];
            worstCountry = var2[6];
        }
        else{
            bestWeather = var2[0];
            bestCountry = var2[6];
            worstWeather = var1[0];
            worstCountry = var1[6];
        }
    }
    else{
        if((city1_points >= city2_points) && (city1_points >= city3_points)){
            bestWeather = var1[0];
            bestCountry = var1[6];
            if (city2_points >= city3_points){
                worstWeather = var3[0];
                worstCountry = var3[6];
            }
            else{
                worstWeather = var2[0];
                worstCountry = var2[6];
            }
        }
        else if((city2_points >= city1_points) && (city2_points >= city3_points)){
            bestWeather = var2[0];
            bestCountry = var2[6];
            if (city1_points >= city3_points){
                worstWeather = var3[0];
                worstCountry = var3[6];
            }
            else{
                worstWeather = var1[0];
                worstCountry = var1[6];
            }
        }
        else{
            bestWeather = var3[0];
            bestCountry = var3[6];
            if (city2_points >= city1_points){
                worstWeather = var1[0];
                worstCountry = var1[6];
            }
            else{
                worstWeather = var2[0];
                worstCountry = var2[6];
            }
        } 
    }
    document.getElementById("weatherStats").innerHTML="The place with the best weather is "+bestWeather+", "+bestCountry+". The place with the worst weather is "+worstWeather+", "+worstCountry+"."; 
}

/*
 * Saves arrays with basic weather info
 */
function saveWeather(var1,var2,var3){
    return var1, var2, var3;
}

/*
 * Refreshes Weather Data to get the most up to date information
 */
function refreshWeather(){
    getWeather(city1);
    getWeather(city2);
    if(city3 != undefined){
        getWeather(city3);
    }  
}

/*
 * Formats the time to YYYY:MM:DD:HH:MM:SS format
 */
function timeFormat(x){
    var date = new Date(x*1000);
    var year = (date.getYear())+1900; //added 1900 as that's the year date was based on
    var month = (date.getMonth())+1; //added 1 because it's on 0-based
    var day = date.getDate();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = "0" + date.getSeconds();
    var formatted = year+":"+month+":"+day+":"+hours+":"+minutes+":"+seconds;
    return formatted;
}

/*
 * function allows information to be set to a Local Storage. 
 * It puts them in a place called cityStorage, and is 
 * numbered 1, 2, or 3 based off of the city number
 */
function addToStorage(x,int){
    //var add = //JSON.parse(localStorage.getItem('cityStorage'));
    //add.push(x);
    localStorage.setItem('cityStorage'+int, JSON.stringify(x));
    //readStorage(int);
}
function addCityToStorage(x){
    localStorage.setItem('city3Storage', JSON.stringify(x));
}

/*
 * function allows user to clear local Storage
 */
function clearStorage(){
    localStorage.clear();
}


/*
 * function changes format to go to hours, minutes, and seconds
 */
function formatToHours(d) {
    d = Number(d);
    var h = Math.floor(d / 3600);
    var m = Math.floor(d % 3600 / 60);
    var s = Math.floor(d % 3600 % 60);

    var hDisplay = h > 0 ? h + (h == 1 ? " hour, " : " hours, ") : "";
    var mDisplay = m > 0 ? m + (m == 1 ? " minute, " : " minutes, ") : "";
    var sDisplay = s > 0 ? s + (s == 1 ? " second" : " seconds") : "";
    return hDisplay + mDisplay + sDisplay; 
}
