/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.util;

import android.content.Context;
import android.net.wimax.WimaxHelper;
import android.provider.Settings;

import android.telephony.TelephonyManager;
import com.android.internal.telephony.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.android.settings.R;

public class PowerWidgetUtil {
    public static final String BUTTON_WIFI = "toggleWifi";
    public static final String BUTTON_GPS = "toggleGPS";
    public static final String BUTTON_BLUETOOTH = "toggleBluetooth";
    public static final String BUTTON_BRIGHTNESS = "toggleBrightness";
    public static final String BUTTON_SOUND = "toggleSound";
    public static final String BUTTON_SYNC = "toggleSync";
    public static final String BUTTON_WIFIAP = "toggleWifiAp";
    public static final String BUTTON_SCREENTIMEOUT = "toggleScreenTimeout";
    public static final String BUTTON_MOBILEDATA = "toggleMobileData";
    public static final String BUTTON_LOCKSCREEN = "toggleLockScreen";
    public static final String BUTTON_NETWORKMODE = "toggleNetworkMode";
    public static final String BUTTON_AUTOROTATE = "toggleAutoRotate";
    public static final String BUTTON_AIRPLANE = "toggleAirplane";
    public static final String BUTTON_FLASHLIGHT = "toggleFlashlight";
    public static final String BUTTON_SLEEP = "toggleSleepMode";
    public static final String BUTTON_MEDIA_PLAY_PAUSE = "toggleMediaPlayPause";
    public static final String BUTTON_MEDIA_PREVIOUS = "toggleMediaPrevious";
    public static final String BUTTON_MEDIA_NEXT = "toggleMediaNext";
    public static final String BUTTON_LTE = "toggleLte";
    public static final String BUTTON_WIMAX = "toggleWimax";
    public static final String BUTTON_PROFILE = "toggleProfile";

    public static final HashMap<String, ButtonInfo> BUTTONS = new HashMap<String, ButtonInfo>();
    static {
        BUTTONS.put(BUTTON_AIRPLANE, new PowerWidgetUtil.ButtonInfo(
                BUTTON_AIRPLANE, R.string.title_toggle_airplane,
                "com.android.systemui:drawable/stat_airplane_on"));
        BUTTONS.put(BUTTON_AUTOROTATE, new PowerWidgetUtil.ButtonInfo(
                BUTTON_AUTOROTATE, R.string.title_toggle_autorotate,
                "com.android.systemui:drawable/stat_orientation_on"));
        BUTTONS.put(BUTTON_BLUETOOTH, new PowerWidgetUtil.ButtonInfo(
                BUTTON_BLUETOOTH, R.string.title_toggle_bluetooth,
                "com.android.systemui:drawable/stat_bluetooth_on"));
        BUTTONS.put(BUTTON_BRIGHTNESS, new PowerWidgetUtil.ButtonInfo(
                BUTTON_BRIGHTNESS, R.string.title_toggle_brightness,
                "com.android.systemui:drawable/stat_brightness_on"));
        BUTTONS.put(BUTTON_FLASHLIGHT, new PowerWidgetUtil.ButtonInfo(
                BUTTON_FLASHLIGHT, R.string.title_toggle_flashlight,
                "com.android.systemui:drawable/stat_flashlight_on"));
        BUTTONS.put(BUTTON_GPS, new PowerWidgetUtil.ButtonInfo(
                BUTTON_GPS, R.string.title_toggle_gps, "com.android.systemui:drawable/stat_gps_on"));
        BUTTONS.put(BUTTON_LOCKSCREEN, new PowerWidgetUtil.ButtonInfo(
                BUTTON_LOCKSCREEN, R.string.title_toggle_lockscreen,
                "com.android.systemui:drawable/stat_lock_screen_on"));
        BUTTONS.put(BUTTON_MOBILEDATA, new PowerWidgetUtil.ButtonInfo(
                BUTTON_MOBILEDATA, R.string.title_toggle_mobiledata,
                "com.android.systemui:drawable/stat_data_on"));
        BUTTONS.put(BUTTON_NETWORKMODE, new PowerWidgetUtil.ButtonInfo(
                BUTTON_NETWORKMODE, R.string.title_toggle_networkmode,
                "com.android.systemui:drawable/stat_2g3g_on"));
        BUTTONS.put(BUTTON_SCREENTIMEOUT, new PowerWidgetUtil.ButtonInfo(
                BUTTON_SCREENTIMEOUT, R.string.title_toggle_screentimeout,
                "com.android.systemui:drawable/stat_screen_timeout_on"));
        BUTTONS.put(BUTTON_SLEEP, new PowerWidgetUtil.ButtonInfo(
                BUTTON_SLEEP, R.string.title_toggle_sleep,
                "com.android.systemui:drawable/stat_sleep"));
        BUTTONS.put(BUTTON_SOUND, new PowerWidgetUtil.ButtonInfo(
                BUTTON_SOUND, R.string.title_toggle_sound,
                "com.android.systemui:drawable/stat_ring_on"));
        BUTTONS.put(BUTTON_SYNC, new PowerWidgetUtil.ButtonInfo(
                BUTTON_SYNC, R.string.title_toggle_sync,
                "com.android.systemui:drawable/stat_sync_on"));
        BUTTONS.put(BUTTON_WIFI, new PowerWidgetUtil.ButtonInfo(
                BUTTON_WIFI, R.string.title_toggle_wifi,
                "com.android.systemui:drawable/stat_wifi_on"));
        BUTTONS.put(BUTTON_WIFIAP, new PowerWidgetUtil.ButtonInfo(
                BUTTON_WIFIAP, R.string.title_toggle_wifiap,
                "com.android.systemui:drawable/stat_wifi_ap_on"));
        BUTTONS.put(BUTTON_MEDIA_PREVIOUS, new PowerWidgetUtil.ButtonInfo(
                BUTTON_MEDIA_PREVIOUS, R.string.title_toggle_media_previous,
                "com.android.systemui:drawable/stat_media_previous"));
        BUTTONS.put(BUTTON_MEDIA_PLAY_PAUSE, new PowerWidgetUtil.ButtonInfo(
                BUTTON_MEDIA_PLAY_PAUSE, R.string.title_toggle_media_play_pause,
                "com.android.systemui:drawable/stat_media_play"));
        BUTTONS.put(BUTTON_MEDIA_NEXT, new PowerWidgetUtil.ButtonInfo(
                BUTTON_MEDIA_NEXT, R.string.title_toggle_media_next,
                "com.android.systemui:drawable/stat_media_next"));
        int lteOnCdmaMode = TelephonyManager.getDefault().getLteOnCdmaMode();
        if(Phone.LTE_ON_CDMA_TRUE == lteOnCdmaMode) {
            BUTTONS.put(BUTTON_LTE, new PowerWidgetUtil.ButtonInfo(
                    BUTTON_LTE, R.string.title_toggle_lte,
                    "com.android.systemui:drawable/stat_lte_on"));
        }
        BUTTONS.put(BUTTON_WIMAX, new PowerWidgetUtil.ButtonInfo(
                BUTTON_WIMAX, R.string.title_toggle_wimax,
                "com.android.systemui:drawable/stat_wimax_on"));
        BUTTONS.put(BUTTON_PROFILE, new PowerWidgetUtil.ButtonInfo(
                BUTTON_PROFILE, R.string.title_toggle_profile,
                "com.android.systemui:drawable/ic_settings_profile"));
    }

    private static final String BUTTON_DELIMITER = "|";
    private static final String BUTTONS_DEFAULT = BUTTON_BLUETOOTH
                             + BUTTON_DELIMITER + BUTTON_BRIGHTNESS
                             + BUTTON_DELIMITER + BUTTON_GPS
                             + BUTTON_DELIMITER + BUTTON_SYNC
                             + BUTTON_DELIMITER + BUTTON_WIFI
                             + BUTTON_DELIMITER + BUTTON_FLASHLIGHT;

    public static String getCurrentButtons(Context context) {
        String buttons = Settings.System.getString(context.getContentResolver(),
                Settings.System.WIDGET_BUTTONS);
        if (buttons == null) {
            buttons = BUTTONS_DEFAULT;
            if (WimaxHelper.isWimaxSupported(context)) { buttons +=
            BUTTON_DELIMITER + BUTTON_WIMAX; }
            /* if (context.getResources().getBoolean(R.bools.has_led_flash)) {
                buttons += BUTTON_DELIMITER + BUTTON_FLASHLIGHT;
            } */
        }
        return buttons;
    }

    public static void saveCurrentButtons(Context context, String buttons) {
        Settings.System.putString(context.getContentResolver(),
                Settings.System.WIDGET_BUTTONS, buttons);
    }

    public static String mergeInNewButtonString(String oldString, String newString) {
        ArrayList<String> oldList = getButtonListFromString(oldString);
        ArrayList<String> newList = getButtonListFromString(newString);
        ArrayList<String> mergedList = new ArrayList<String>();

        for (String button : oldList) {
            if (newList.contains(button)) {
                mergedList.add(button);
            }
        }

        for (String button : newList) {
            if (!mergedList.contains(button)) {
                mergedList.add(button);
            }
        }

        return getButtonStringFromList(mergedList);
    }

    public static ArrayList<String> getButtonListFromString(String buttons) {
        return new ArrayList<String>(Arrays.asList(buttons.split("\\|")));
    }

    public static String getButtonStringFromList(ArrayList<String> buttons) {
        if (buttons == null || buttons.size() <= 0) {
            return "";
        } else {
            String s = buttons.get(0);
            for (int i = 1; i < buttons.size(); i++) {
                s += BUTTON_DELIMITER + buttons.get(i);
            }
            return s;
        }
    }

    public static class ButtonInfo {
        private String mId;
        private int mTitleResId;
        private String mIcon;

        public ButtonInfo(String id, int titleResId, String icon) {
            mId = id;
            mTitleResId = titleResId;
            mIcon = icon;
        }

        public String getId() {
            return mId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public String getIcon() {
            return mIcon;
        }
    }
}
