function genderChanged(obj) {
    let value = obj.value;
    if (value === "all") {
        let x = location.host;
        let URL = "http://" + x + "/taobao/products?action=display_products";
        location.assign(URL);
    } else if (value === "T-SHIRT") {
        let x = location.host;
        let URL = "http://" + x + "/taobao/products?action=Tshirt";
        location.assign(URL);
    } else if (value === "SHIRT") {
        let x = location.host;
        let URL = "http://" + x + "/taobao/products?action=SHIRT";
        location.assign(URL);
    }
}