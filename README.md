#Android Platform Experiments
##Experiments to show the impact on inappropriate background services

We made following conclusions after series of experiments:

1.  Under concurrent environment, default service consumes more power than intent service.
2.  Under concurrent environment, when dealing with a small amount of workload, default service requires less time to accomplish its job.
3.  Under concurrent environment, when dealing with a large amount of workload, intent service requires less time to accomplish its job for the reason of less conflicts and competitions.
4.  As the difference in timing is not significant between default and intent service, and services always run on background so running time is not concerned too much, developers should use intent service rather than default service.

##Experiments to show the inappropriately programmed broadcast receivers

1.  Unnecessary broadcast receiver will consume more power. If the frequency of broadcast's occurrence is low, we can accept the waste of power and CPU time slot. In other cases when the frequency of occurrence becomes fairly high, the wasted power and CPU time slot will be quite significant.

##Experiments to verify the programming principles to optimize the memory management

Here are some wisdom words from [Google's documentation](http://developer.android.com/training/articles/perf-tips.html)

	There are two basic rules for writing efficient code:

	1.	Don't do work that you don't need to do.
	2.	Don't allocate memory if you can avoid it.

	One of the trickiest problems you'll face when micro-optimizing an Android app is that your app 
	is certain to be running on multiple types of hardware. Different versions of the VM running on 
	different processors running at different speeds. It's not even generally the case that you can 
	simply say "device X is a factor F faster/slower than device Y", and scale your results from one 
	device to others. In particular, measurement on the emulator tells you very little about 
	performance on any device. There are also huge differences between devices with and without a 
	JIT: the best code for a device with a JIT is not always the best code for a device without.

We made following conclusions after series of experiments:

1.	Use 'static final' for constants 1.6x faster than just 'static'.
2.	Make the field public and access directly is 2x faster than using getters/setters.
3.	Use enhanced for-loop(foreach) for a significant improvement to Collections who have implemented interface Itarable. Do not use it for Collections who have not implemented the interface.

##Experiments to measure the efficiency of center mode

We made following conclusions after series of experiments:

1.  With single mode we can achieve a high computing power rate so we could accomplish the work faster. Single mode is a good choice when our work is time sensitive, but with a sacrifice of power.
2.  When we have many tasks to handle, concurrent center mode is slower than single mode, and it consumes more power. Also this mode has no advantages to queued center mode. For power and time concerns we should abandon this mode.
3.  When we have many tasks to handle, queued center mode consumes minimum power, but it’s the slowest among these three modes. We may choose this mode to save power when our work is not time sensitive.

##Experiments to trace the UI rendering process and scheduling policy for possible optimization

The Android UI rendering system is quite complex but worth of deep learning. We have 
worked out some technical reports for internal use only. If you are interested in this field, 
[Shengyang Luo's blog](http://blog.csdn.net/luoshengyang?viewmode=contents) is an awesome resource
you must not miss. But anyway, you should always 'Read The Fucking Source Code'.
