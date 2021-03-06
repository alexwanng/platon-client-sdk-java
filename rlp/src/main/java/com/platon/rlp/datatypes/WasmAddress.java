package com.platon.rlp.datatypes;

import java.math.BigInteger;

import org.web3j.utils.Numeric;

public class WasmAddress {
	private byte[] value;
	private BigInteger bigIntValue;
	private String address;

	public static final int LENGTH = 160;
	public static final int LENGTH_IN_HEX = LENGTH >> 2;
	public static final WasmAddress DEFAULT = new WasmAddress(BigInteger.ZERO);

	public WasmAddress(byte[] value) {
		this.value = value;
		this.bigIntValue = Numeric.toBigInt(value);
		this.address = Numeric.toHexStringWithPrefixZeroPadded(bigIntValue, LENGTH_IN_HEX);
	}

	public WasmAddress(String hexValue) {
		this(Numeric.hexStringToByteArray(hexValue));
	}

	public WasmAddress(BigInteger value) {
		this(value.toByteArray());
	}

	public byte[] getValue() {
		return value;
	}

	public String getAddress() {
		return address;
	}

	public BigInteger getBigIntValue() {
		return bigIntValue;
	}

	@Override
	public String toString() {
		return address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		WasmAddress address = (WasmAddress) o;

		return value != null ? value.equals(address.value) : address.value == null;
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}
}
