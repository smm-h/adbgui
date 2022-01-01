package ir.smmh.adbgui;

import java.awt.event.KeyEvent;

@SuppressWarnings("unused")
public interface KeyEvents {


    int KEYCODE_UNKNOWN = 0;
    int KEYCODE_MENU = 1;
    int KEYCODE_SOFT_RIGHT = 2;
    int KEYCODE_HOME = 3;
    int KEYCODE_BACK = 4;
    int KEYCODE_CALL = 5;
    int KEYCODE_ENDCALL = 6;
    int KEYCODE_0 = 7;
    int KEYCODE_1 = 8;
    int KEYCODE_2 = 9;
    int KEYCODE_3 = 10;
    int KEYCODE_4 = 11;
    int KEYCODE_5 = 12;
    int KEYCODE_6 = 13;
    int KEYCODE_7 = 14;
    int KEYCODE_8 = 15;
    int KEYCODE_9 = 16;
    int KEYCODE_STAR = 17;
    int KEYCODE_POUND = 18;
    int KEYCODE_DPAD_UP = 19;
    int KEYCODE_DPAD_DOWN = 20;
    int KEYCODE_DPAD_LEFT = 21;
    int KEYCODE_DPAD_RIGHT = 22;
    int KEYCODE_DPAD_CENTER = 23;
    int KEYCODE_VOLUME_UP = 24;
    int KEYCODE_VOLUME_DOWN = 25;
    int KEYCODE_POWER = 26;
    int KEYCODE_CAMERA = 27;
    int KEYCODE_CLEAR = 28;
    int KEYCODE_A = 29;
    int KEYCODE_B = 30;
    int KEYCODE_C = 31;
    int KEYCODE_D = 32;
    int KEYCODE_E = 33;
    int KEYCODE_F = 34;
    int KEYCODE_G = 35;
    int KEYCODE_H = 36;
    int KEYCODE_I = 37;
    int KEYCODE_J = 38;
    int KEYCODE_K = 39;
    int KEYCODE_L = 40;
    int KEYCODE_M = 41;
    int KEYCODE_N = 42;
    int KEYCODE_O = 43;
    int KEYCODE_P = 44;
    int KEYCODE_Q = 45;
    int KEYCODE_R = 46;
    int KEYCODE_S = 47;
    int KEYCODE_T = 48;
    int KEYCODE_U = 49;
    int KEYCODE_V = 50;
    int KEYCODE_W = 51;
    int KEYCODE_X = 52;
    int KEYCODE_Y = 53;
    int KEYCODE_Z = 54;
    int KEYCODE_COMMA = 55;
    int KEYCODE_PERIOD = 56;
    int KEYCODE_ALT_LEFT = 57;
    int KEYCODE_ALT_RIGHT = 58;
    int KEYCODE_SHIFT_LEFT = 59;
    int KEYCODE_SHIFT_RIGHT = 60;
    int KEYCODE_TAB = 61;
    int KEYCODE_SPACE = 62;
    int KEYCODE_SYM = 63;
    int KEYCODE_EXPLORER = 64;
    int KEYCODE_ENVELOPE = 65;
    int KEYCODE_ENTER = 66;
    int KEYCODE_DEL = 67;
    int KEYCODE_GRAVE = 68;
    int KEYCODE_MINUS = 69;
    int KEYCODE_EQUALS = 70;
    int KEYCODE_LEFT_BRACKET = 71;
    int KEYCODE_RIGHT_BRACKET = 72;
    int KEYCODE_BACKSLASH = 73;
    int KEYCODE_SEMICOLON = 74;
    int KEYCODE_APOSTROPHE = 75;
    int KEYCODE_SLASH = 76;
    int KEYCODE_AT = 77;
    int KEYCODE_NUM = 78;
    int KEYCODE_HEADSETHOOK = 79;
    int KEYCODE_FOCUS = 80;
    int KEYCODE_PLUS = 81;
    int KEYCODE_MENU_BUTTON = 82;
    int KEYCODE_NOTIFICATION = 83;
    int KEYCODE_SEARCH = 84;
    int TAG_LAST_KEYCOD = 85;

    static int translateKeyCode(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_HOME:
                return KEYCODE_HOME;
            case KeyEvent.VK_END:
                return KEYCODE_BACK;
            case KeyEvent.VK_ESCAPE:
                return KEYCODE_POWER;
            case KeyEvent.VK_0:
                return KEYCODE_0;
            case KeyEvent.VK_1:
                return KEYCODE_1;
            case KeyEvent.VK_2:
                return KEYCODE_2;
            case KeyEvent.VK_3:
                return KEYCODE_3;
            case KeyEvent.VK_4:
                return KEYCODE_4;
            case KeyEvent.VK_5:
                return KEYCODE_5;
            case KeyEvent.VK_6:
                return KEYCODE_6;
            case KeyEvent.VK_7:
                return KEYCODE_7;
            case KeyEvent.VK_8:
                return KEYCODE_8;
            case KeyEvent.VK_9:
                return KEYCODE_9;
            case KeyEvent.VK_A:
                return KEYCODE_A;
            case KeyEvent.VK_B:
                return KEYCODE_B;
            case KeyEvent.VK_C:
                return KEYCODE_C;
            case KeyEvent.VK_D:
                return KEYCODE_D;
            case KeyEvent.VK_E:
                return KEYCODE_E;
            case KeyEvent.VK_F:
                return KEYCODE_F;
            case KeyEvent.VK_G:
                return KEYCODE_G;
            case KeyEvent.VK_H:
                return KEYCODE_H;
            case KeyEvent.VK_I:
                return KEYCODE_I;
            case KeyEvent.VK_J:
                return KEYCODE_J;
            case KeyEvent.VK_K:
                return KEYCODE_K;
            case KeyEvent.VK_L:
                return KEYCODE_L;
            case KeyEvent.VK_M:
                return KEYCODE_M;
            case KeyEvent.VK_N:
                return KEYCODE_N;
            case KeyEvent.VK_O:
                return KEYCODE_O;
            case KeyEvent.VK_P:
                return KEYCODE_P;
            case KeyEvent.VK_Q:
                return KEYCODE_Q;
            case KeyEvent.VK_R:
                return KEYCODE_R;
            case KeyEvent.VK_S:
                return KEYCODE_S;
            case KeyEvent.VK_T:
                return KEYCODE_T;
            case KeyEvent.VK_U:
                return KEYCODE_U;
            case KeyEvent.VK_V:
                return KEYCODE_V;
            case KeyEvent.VK_W:
                return KEYCODE_W;
            case KeyEvent.VK_X:
                return KEYCODE_X;
            case KeyEvent.VK_Y:
                return KEYCODE_Y;
            case KeyEvent.VK_Z:
                return KEYCODE_Z;
            case KeyEvent.VK_MULTIPLY:
                return KEYCODE_STAR;
            case KeyEvent.VK_NUMBER_SIGN:
                return KEYCODE_POUND;
            case KeyEvent.VK_COMMA:
                return KEYCODE_COMMA;
            case KeyEvent.VK_PERIOD:
                return KEYCODE_PERIOD;
            case KeyEvent.VK_ALT:
                return keyEvent.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT ?
                        KEYCODE_ALT_RIGHT :
                        KEYCODE_ALT_LEFT;
            case KeyEvent.VK_SHIFT:
                return keyEvent.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT ?
                        KEYCODE_SHIFT_RIGHT :
                        KEYCODE_SHIFT_LEFT;
            case KeyEvent.VK_TAB:
                return KEYCODE_TAB;
            case KeyEvent.VK_SPACE:
                return KEYCODE_SPACE;
            case KeyEvent.VK_ENTER:
                return keyEvent.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD ?
                        KEYCODE_DPAD_CENTER :
                        KEYCODE_ENTER;
            case KeyEvent.VK_DELETE:
                return KEYCODE_DEL;
            case KeyEvent.VK_DEAD_TILDE:
            case KeyEvent.VK_BACK_QUOTE:
                return KEYCODE_GRAVE;
            case KeyEvent.VK_MINUS:
                return KEYCODE_MINUS;
            case KeyEvent.VK_EQUALS:
                return KEYCODE_EQUALS;
            case KeyEvent.VK_OPEN_BRACKET:
                return KEYCODE_LEFT_BRACKET;
            case KeyEvent.VK_CLOSE_BRACKET:
                return KEYCODE_RIGHT_BRACKET;
            case KeyEvent.VK_BACK_SLASH:
                return KEYCODE_BACKSLASH;
            case KeyEvent.VK_SEMICOLON:
                return KEYCODE_SEMICOLON;
            case KeyEvent.VK_QUOTE:
                return KEYCODE_APOSTROPHE;
            case KeyEvent.VK_SLASH:
                return KEYCODE_SLASH;
            case KeyEvent.VK_AT:
                return KEYCODE_AT;
            case KeyEvent.VK_NUM_LOCK:
                return KEYCODE_NUM;
            case KeyEvent.VK_PLUS:
                return KEYCODE_PLUS;
            case KeyEvent.VK_CONTEXT_MENU:
                return KEYCODE_MENU_BUTTON;
            case KeyEvent.VK_F1:
                return KEYCODE_MENU;
            case KeyEvent.VK_F2:
                return KEYCODE_CAMERA;
            case KeyEvent.VK_F3:
                return KEYCODE_SEARCH;
            case KeyEvent.VK_F4:
                return KEYCODE_SYM;
            case KeyEvent.VK_F5:
                return KEYCODE_EXPLORER;
            case KeyEvent.VK_F6:
                return KEYCODE_ENVELOPE;
            case KeyEvent.VK_F7:
                return KEYCODE_NOTIFICATION;
            case KeyEvent.VK_F8:
                return KEYCODE_FOCUS;
            case KeyEvent.VK_F9:
                return KEYCODE_CALL;
            case KeyEvent.VK_F10:
                return KEYCODE_ENDCALL;
            case KeyEvent.VK_F11:
                return KEYCODE_VOLUME_DOWN;
            case KeyEvent.VK_F12:
                return KEYCODE_VOLUME_UP;
            case KeyEvent.VK_UP:
                return KEYCODE_DPAD_UP;
            case KeyEvent.VK_DOWN:
                return KEYCODE_DPAD_DOWN;
            case KeyEvent.VK_LEFT:
                return KEYCODE_DPAD_LEFT;
            case KeyEvent.VK_RIGHT:
                return KEYCODE_DPAD_RIGHT;
//            case KeyEvent.VK_:
//                return KEYCODE_SOFT_RIGHT;
//            case KeyEvent.VK_:
//                return KEYCODE_CLEAR;
//            case KeyEvent.VK_:
//                return KEYCODE_HEADSETHOOK;
//            case KeyEvent.VK_:
//                return TAG_LAST_KEYCOD;
            default:
                return KEYCODE_UNKNOWN;
        }
    }
}
