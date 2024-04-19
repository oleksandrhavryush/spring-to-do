!function (e, t) {
    "use strict";
    if ("object" == typeof module && "object" == typeof module.exports) {
        module.exports = e.document ? t(e, !0) : function (e) {
            if (!e.document) throw new Error("jQuery requires a window with a document");
            return t(e);
        };
    } else {
        t(e);
    }
}("undefined" != typeof window ? window : this, function (e, t) {
    // тут може бути ваш код
});
