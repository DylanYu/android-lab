#Android Platform Experiments
##Experiments to show the impact on inappropriate background services

We make following conclusions after series of experiments:

1.  Under concurrent environment, default service consumes more power than intent service.
2.  Under concurrent environment, when dealing with a small amount of workload, default service requires less time to accomplish its job.
3.  Under concurrent environment, when dealing with a large amount of workload, intent service requires less time to accomplish its job for the reason of less conflicts and competitions.
4.  As the difference in used time is not significant between default and intent service, and services always run on background so running time is not concerned too much, developers should use intent service rather than default service.

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

We made following conclusions after a series of experiments:

1.	Use 'static final' for constants 1.6x faster than just 'static'.
2.	Make the field public and access directly is 2x faster than using getters/setters.
3.	Use enhanced for-loop(foreach) for a significant improvement to Collections who have implemented interface Itarable. Do not use it for Collections who have not implemented the interface.

##Experiments to trace the UI rendering process and scheduling policy for possible optimization
TBA
##Experiments to measure the efficiency of the facility of iOS notification center
TBA
