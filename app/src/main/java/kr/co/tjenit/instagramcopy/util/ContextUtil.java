package kr.co.tjenit.instagramcopy.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjenit.instagramcopy.data.UserData;

/**
 * Created by the on 2017-08-17.
 */

// 앱 내에 기록해야될만한 요소들을 기록하는 용도.
// 기록한다? 앱이 완전히 종료되어도 유지되어야 하는 데이터
public class ContextUtil {

    //    기본적으로는 로그인을 하지 않은 상태로 정의
    //    loginUserData가 null이라면 비 로그인상태.
    public static UserData loginUserData = null;

    //    멤버변수가 있으면 게터/세터 필요.
    //    수동으로 구현하자.

    // SharedPreference를 이용할수 있게 하기 위한 context를 재료 1번.
    // 실제로 저장될 근본 데이터인 UserData를 재료 2번.
    private final static String prefName = "instaPref";
    private final static String LOGIN_USER_ID = "LOGIN_USER_ID";
    private final static String LOGIN_USER_NAME = "LOGIN_USER_NAME";
    private final static String LOGIN_USER_NICKNAME = "LOGIN_USER_NICKNAME";
    private final static String LOGIN_USER_PROFILE_URL = "LOGIN_USER_PROFILE_URL";


    public static void setLoginUser(Context context, UserData loginUser) {

        // 기록을 하기 위한 메모장 SharedPreference를 소환.
        // 소환을 할때 항상 메모 (꼬리표) 붙여서 소환.
        // 저장한 pref의 꼬리표와, 불러올때 pref의 꼬리표는 동일해야만 데이터가 공유.
        // MODE_PRIVATE은 외부에 공개하지 않겠다 라는 의미.
        SharedPreferences pref = context.getSharedPreferences(prefName, context.MODE_PRIVATE);

        // 실제로 저장하는 부분.
        pref.edit().putInt(LOGIN_USER_ID, loginUser.getUserId()).commit();
        pref.edit().putString(LOGIN_USER_NAME, loginUser.getName()).commit();
        pref.edit().putString(LOGIN_USER_NICKNAME, loginUser.getNickName()).commit();
        pref.edit().putString(LOGIN_USER_PROFILE_URL, loginUser.getProfileImgURL()).commit();
    }

    public static UserData getLoginUserData(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, context.MODE_PRIVATE);

        int userId = pref.getInt(LOGIN_USER_ID, -1);
        // 로그인을 한 상태인지 체크
        if (userId != -1) {
            if (loginUserData == null) {
                loginUserData = new UserData(); // 초기화부터 실행.
                loginUserData.setUserId(pref.getInt(LOGIN_USER_ID, -1));
                loginUserData.setName(pref.getString(LOGIN_USER_NAME, ""));
                loginUserData.setNickName(pref.getString(LOGIN_USER_NICKNAME, ""));
                loginUserData.setProfileImgURL(pref.getString(LOGIN_USER_PROFILE_URL, ""));
            }
        }

        else {
            loginUserData=null;
        }

        return loginUserData;
    }

    public static void logoutProcess(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, context.MODE_PRIVATE);

        pref.edit().putInt(LOGIN_USER_ID,-1).commit();
        pref.edit().putString(LOGIN_USER_NAME,"").commit();
        pref.edit().putString(LOGIN_USER_NICKNAME,"").commit();
        pref.edit().putString(LOGIN_USER_PROFILE_URL,"").commit();
    }

    public static int getLoginId(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, context.MODE_PRIVATE);
        return pref.getInt(LOGIN_USER_ID, -1);
    }

}
