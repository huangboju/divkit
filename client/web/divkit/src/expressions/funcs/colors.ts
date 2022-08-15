import type { ColorValue, EvalValue, NumberValue, StringValue } from '../eval';
import { registerFunc } from './funcs';
import { COLOR, NUMBER, STRING } from '../const';
import { ParsedColor } from '../../utils/correctColor';
import { safeConvertColor, stringifyColor } from '../utils';

function colorGetter(field: keyof ParsedColor): (color: StringValue | ColorValue) => EvalValue {
    return color => {
        const parsed = safeConvertColor(color.value);

        return {
            type: NUMBER,
            value: parsed[field] / 255
        };
    };
}

function colorSetter(field: keyof ParsedColor): (color: StringValue | ColorValue, val: NumberValue) => EvalValue {
    return (color, val) => {
        const parsed = safeConvertColor(color.value);

        parsed[field] = val.value * 255;

        return {
            type: color.type,
            value: stringifyColor(parsed)
        };
    };
}

const getColorAlpha = colorGetter('a');
const getColorRed = colorGetter('r');
const getColorGreen = colorGetter('g');
const getColorBlue = colorGetter('b');

const setColorAlpha = colorSetter('a');
const setColorRed = colorSetter('r');
const setColorGreen = colorSetter('g');
const setColorBlue = colorSetter('b');

function rgb(red: NumberValue, green: NumberValue, blue: NumberValue): EvalValue {
    const parsed: ParsedColor = {
        a: 255,
        r: red.value * 255,
        g: green.value * 255,
        b: blue.value * 255
    };

    return {
        type: STRING,
        value: stringifyColor(parsed)
    };
}

function argb(alpha: NumberValue, red: NumberValue, green: NumberValue, blue: NumberValue): EvalValue {
    const parsed: ParsedColor = {
        a: alpha.value * 255,
        r: red.value * 255,
        g: green.value * 255,
        b: blue.value * 255
    };

    return {
        type: STRING,
        value: stringifyColor(parsed)
    };
}

export function registerColors(): void {
    registerFunc('getColorAlpha', [STRING], getColorAlpha);
    registerFunc('getColorAlpha', [COLOR], getColorAlpha);
    registerFunc('getColorRed', [STRING], getColorRed);
    registerFunc('getColorRed', [COLOR], getColorRed);
    registerFunc('getColorGreen', [STRING], getColorGreen);
    registerFunc('getColorGreen', [COLOR], getColorGreen);
    registerFunc('getColorBlue', [STRING], getColorBlue);
    registerFunc('getColorBlue', [COLOR], getColorBlue);

    registerFunc('setColorAlpha', [STRING, NUMBER], setColorAlpha);
    registerFunc('setColorAlpha', [COLOR, NUMBER], setColorAlpha);
    registerFunc('setColorRed', [STRING, NUMBER], setColorRed);
    registerFunc('setColorRed', [COLOR, NUMBER], setColorRed);
    registerFunc('setColorGreen', [STRING, NUMBER], setColorGreen);
    registerFunc('setColorGreen', [COLOR, NUMBER], setColorGreen);
    registerFunc('setColorBlue', [STRING, NUMBER], setColorBlue);
    registerFunc('setColorBlue', [COLOR, NUMBER], setColorBlue);

    registerFunc('rgb', [NUMBER, NUMBER, NUMBER], rgb);
    registerFunc('argb', [NUMBER, NUMBER, NUMBER, NUMBER], argb);
}
