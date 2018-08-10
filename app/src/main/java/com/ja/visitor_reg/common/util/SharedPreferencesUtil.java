package com.ja.visitor_reg.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.ja.visitor_reg.config.GlobalConfig;

import java.util.Map;
import java.util.Set;

/**
 * SharedPerferences工具类
 */
public class SharedPreferencesUtil {
    private static SharedPreferencesUtil mInstance = null;
    private SharedPreferences mSP;
    private SharedPreferences.Editor mEditor;
    //    private static final String SP_FILE = "data.xml";
    private static final String SP_FILE = GlobalConfig.SP_SAVE_FILE;


    private SharedPreferencesUtil(Context context, String FILE_NAME) {
        mSP = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        mEditor = mSP.edit();
    }

    /**
     * 用全局 Application 的 Context 获取实例
     **/
    public static SharedPreferencesUtil getInstance() {
        if (null == mInstance && null != ApplicationUtil.getContext()) {
            mInstance = new SharedPreferencesUtil(ApplicationUtil.getContext(), SP_FILE);
        }

        return mInstance;
    }

    /**
     * 用 Activity等 的 Context 获取实例
     **/
    public static SharedPreferencesUtil getInstance(Context context) {
        if (null == mInstance && null != context) {
            mInstance = new SharedPreferencesUtil(context, SP_FILE);
        }
        return mInstance;
    }

    /**
     * 移除某个key值已经对应的值
     */
    public void remove(String key) {
        if (null != mEditor) {
            mEditor.remove(key);
            mEditor.commit();
        }
    }

    /**
     * 清除所有数据
     */
    public void clear() {
        if (null != mEditor) {
            mEditor.clear();
            mEditor.commit();
        }
    }

    /**
     * 查询某个key是否存在
     */
    public Boolean contain(String key) {
        if (null == mSP) {
            return false;
        }
        return mSP.contains(key);
    }

    /**
     * 存储
     */
    public boolean put(String key, Object object) {
        if (StringUtil.isEmptyTrimed(key)) {
            return false;
        }

        if (object instanceof String) {
            return putStringValue(key, (String) object);
        } else if (object instanceof Integer) {
            return putIntValue(key, (Integer) object);
        } else if (object instanceof Boolean) {
            return putBooleanValue(key, (Boolean) object);
        } else if (object instanceof Float) {
            return putFloatValue(key, (Float) object);
        } else if (object instanceof Long) {
            return putLongValue(key, (Long) object);
        } else {
            return putStringValue(key, object.toString());
        }
    }

    /**
     * 获取保存的数据
     */
    public Object get(String key, Object defValue) {
        if (defValue instanceof String) {
            return getStringValue(key, (String) defValue);
        } else if (defValue instanceof Integer) {
            return getIntValue(key, (Integer) defValue);
        } else if (defValue instanceof Boolean) {
            return getBooleanValue(key, (Boolean) defValue);
        } else if (defValue instanceof Float) {
            return getFloatValue(key, (Float) defValue);
        } else if (defValue instanceof Long) {
            return getLongValue(key, (Long) defValue);
        } else if (defValue instanceof Set) {
            return getSetValue(key, (Set<String>) defValue);
        } else {
            return getStringValue(key, null);
        }
    }

    public boolean putStringValue(String key, String value) {
        if (!StringUtil.isEmptyTrimed(key) && null != mSP) {
            mEditor = mSP.edit();
            mEditor.putString(key, value);
            return mEditor.commit();
        }
        return false;
    }


    public boolean putIntValue(String key, Integer value) {
        if (!StringUtil.isEmptyTrimed(key) && null != mSP) {
            mEditor = mSP.edit();
            mEditor.putInt(key, value);
            return mEditor.commit();
        }
        return false;
    }


    public boolean putLongValue(String key, long value) {
        if (!StringUtil.isEmptyTrimed(key) && null != mSP) {
            mEditor = mSP.edit();
            mEditor.putLong(key, value);
            return mEditor.commit();
        }
        return false;
    }


    public boolean putFloatValue(String key, Float value) {
        if (!StringUtil.isEmptyTrimed(key) && null != mSP) {
            mEditor = mSP.edit();
            mEditor.putFloat(key, value);
            return mEditor.commit();
        }
        return false;
    }


    public boolean putBooleanValue(String key, boolean value) {
        if (!StringUtil.isEmptyTrimed(key) && null != mSP) {
            mEditor = mSP.edit();
            mEditor.putBoolean(key, value);
            return mEditor.commit();
        }
        return false;
    }

    public boolean putSetValue(String key, Set<String> value) {
        if (!StringUtil.isEmptyTrimed(key) && null != mSP) {
            mEditor = mSP.edit();
            mEditor.putStringSet(key, value);
            return mEditor.commit();
        }
        return false;
    }

    public String getStringValue(String key, String defValue) {
        if (null == mSP) {
            return null;
        }
        return mSP.getString(key, defValue);
    }

    public int getIntValue(String key, Integer defValue) {
        if (null == mSP) {
            return -1;
        }
        return mSP.getInt(key, defValue);
    }

    public long getLongValue(String key, Long defValue) {
        if (null == mSP) {
            return -1;
        }
        return mSP.getLong(key, defValue);
    }

    public float getFloatValue(String key, Float defValue) {
        if (null == mSP) {
            return -1;
        }
        return mSP.getFloat(key, defValue);
    }


    public boolean getBooleanValue(String key, Boolean defValue) {
        if (null == mSP) {
            return false;
        }
        return mSP.getBoolean(key, defValue);

    }

    public Set<String> getSetValue(String key, Set<String> defValue) {
        if (null == mSP) {
            return null;
        }
        return mSP.getStringSet(key, defValue);
    }

    /**
     * 返回所有键值对
     *
     * @return
     */
    public Map<String, ?> getAllValue() {
        if (null == mSP) {
            return null;
        }
        return mSP.getAll();
    }


}
