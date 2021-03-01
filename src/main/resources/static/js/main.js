/**
 * JS File to handle server side events
 * @returns
 */
function LoadKitchenDataa() {
    this.source = null;
    this.start = function () {
        let kitchenDishes = document.getElementById("kitchenDishes");
        this.source = new EventSource("/dish-finder");
        this.source.addEventListener("message", function (event) {
            // These events are JSON, so parsing.
            let kitchen_dish = JSON.parse(event.data);
 
            let rowElement = kitchenDishes.getElementsByTagName("tbody")[0].insertRow(0);
            let cell0 = rowElement.insertCell(0);
            let cell1 = rowElement.insertCell(1);
 
            cell0.innerHTML = kitchen_dish.description;
            cell1.innerHTML = kitchen_dish.delivered;
        });
 
        this.source.onerror = function () {
            this.close();
        };
    };
 
    this.stop = function () {
        this.source.close();
    };
}
 
kitchenDishes = new LoadKitchenDataa();
 
/*
 * Register callbacks for starting and stopping the SSE controller.
 */
window.onload = function () {
	kitchenDishes.start();
};
 
window.onbeforeunload = function () {
	kitchenDishes.stop();
}