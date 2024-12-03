let display = document.getElementById('display');
let lastChar = '';
let needsReset = false;

function append(value) {
    if (needsReset) {
        clearDisplay();
        needsReset = false;
    }

    if (['+', '-', '*', '/'].includes(value) && ['+', '-', '*', '/'].includes(lastChar)) {
        alert('Операторы не могут быть последовательными!');
        return;
    }

    if (value === '.') {
        const lastNumber = display.value.split(/[\+\-\*\/]/).slice(-1)[0];
        if (lastNumber.includes('.')) {
            alert('Точка может быть только один раз в числе!');
            return;
        }
    }

    display.value += value;
    lastChar = value;
}

function calculate() {
    try {
        let result = eval(display.value);
        if (isNaN(result) || result === -Infinity || result === Infinity) {
            needsReset = true;
            alert('Ошибка: Неверное математическое выражение!');
        } else {
            display.value = result;
            lastChar = '';
        }
    } catch (error) {
        alert('Ошибка в выражении! Убедитесь, что выражение корректно.');
        needsReset = true;
    }
}

function clearDisplay() {
    display.value = '';
    lastChar = '';
}

function removeLast() {
    display.value = display.value.slice(0, -1);
    lastChar = display.value.slice(-1);
}
