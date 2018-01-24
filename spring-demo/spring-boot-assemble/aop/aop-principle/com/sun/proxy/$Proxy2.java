// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package com.sun.proxy;

import cn.zxf.spring_aop.java_proxy.ILogService;
import cn.zxf.spring_aop.java_proxy.IUserService;
import java.lang.reflect.*;

public final class $Proxy2 extends Proxy
	implements IUserService, ILogService
{

	private static Method m1;
	private static Method m3;
	private static Method m4;
	private static Method m2;
	private static Method m0;

	public $Proxy2(InvocationHandler invocationhandler)
	{
		super(invocationhandler);
	}

	public final boolean equals(Object obj)
	{
		try
		{
			return ((Boolean)super.h.invoke(this, m1, new Object[] {
				obj
			})).booleanValue();
		}
		catch (Error ) { }
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final String getUserName(String s)
	{
		try
		{
			return (String)super.h.invoke(this, m3, new Object[] {
				s
			});
		}
		catch (Error ) { }
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final String log(String s)
	{
		try
		{
			return (String)super.h.invoke(this, m4, new Object[] {
				s
			});
		}
		catch (Error ) { }
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final String toString()
	{
		try
		{
			return (String)super.h.invoke(this, m2, null);
		}
		catch (Error ) { }
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final int hashCode()
	{
		try
		{
			return ((Integer)super.h.invoke(this, m0, null)).intValue();
		}
		catch (Error ) { }
		catch (Throwable throwable)
		{
			throw new UndeclaredThrowableException(throwable);
		}
	}

	static 
	{
		try
		{
			m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] {
				Class.forName("java.lang.Object")
			});
			m3 = Class.forName("cn.zxf.spring_aop.java_proxy.IUserService").getMethod("getUserName", new Class[] {
				Class.forName("java.lang.String")
			});
			m4 = Class.forName("cn.zxf.spring_aop.java_proxy.ILogService").getMethod("log", new Class[] {
				Class.forName("java.lang.String")
			});
			m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
			m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
		}
		catch (NoSuchMethodException nosuchmethodexception)
		{
			throw new NoSuchMethodError(nosuchmethodexception.getMessage());
		}
		catch (ClassNotFoundException classnotfoundexception)
		{
			throw new NoClassDefFoundError(classnotfoundexception.getMessage());
		}
	}
}
