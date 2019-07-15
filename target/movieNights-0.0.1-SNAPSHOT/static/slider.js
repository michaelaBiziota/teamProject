//  Slider
var slider = document.getElementById("myRange");
var output = document.getElementById("year");
output.innerHTML = slider.value;

slider.oninput = function () {
    output.innerHTML = this.value;
}
 // Slider END