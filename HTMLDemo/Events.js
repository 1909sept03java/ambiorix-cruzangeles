window.onload = function () {
    let div1 = this.document.getElementById("div1").addEventListener("mousemove", () => {
    console.log(`x: ${event.pageX} , y: ${event.pageY}`);
    document.getElementById("p2").innerHTML = event.pageX;
    document.getElementById("p3").innerHTML = event.pageY;
    });
}