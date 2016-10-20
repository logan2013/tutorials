package com.imtzp.defaultmem;

public class DirectMemory {

	/**
	 * Write amout of direct memory used to standard output
	 * 
	 * using SharedSecrets, JavaNetAcess, the direct Buffer Pool,
	 * 
	 * and methods getMemoryUsed() and getTotalCapacity().
	 */
	public static void writeUsedDirectMemoryToStdOut() {

		final double sharedSecretsMemoryUsed = MemoryUnit.BYTES
				.toMegaBytes(sun.misc.SharedSecrets.getJavaNioAccess().getDirectBufferPool().getMemoryUsed());

		System.out.println("sun.misc.SharedSecrets.getJavaNioAccess().getDirectBufferPool().getMemoryUsed(): "
				+ sharedSecretsMemoryUsed + " MB");

		final double sharedSecretsTotalCapacity = MemoryUnit.BYTES
				.toMegaBytes(sun.misc.SharedSecrets.getJavaNioAccess().getDirectBufferPool().getTotalCapacity());

		System.out.println("sun.misc.SharedSecrets.getJavaNioAccess().getDirectBufferPool().getTotalCapacity(): "
				+ sharedSecretsTotalCapacity + " MB");
	}

	/**
	 * Write maximum direct memory size set (explicitly or implicitly) for this
	 * VM instance
	 * 
	 * using VM's method maxDirectMemory().
	 */
	public static void writeMaxmiumDirectorySizeToStdOut() {
		final double vmSize = MemoryUnit.BYTES.toMegaBytes(sun.misc.VM.maxDirectMemory());
		System.out.println("sun.misc.VM.maxDirectMemory(): " + vmSize + " MB");
	}

	public static void main(String[] args) {
		writeMaxmiumDirectorySizeToStdOut();
	}
}
