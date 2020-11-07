package com.primavera.CoursProject.application.dto;

import java.util.HashSet;
import java.util.Set;

import com.primavera.CoursProject.domain.IAsset;

public class EntryDTO {
	//no seria mejor que entry tuviera un array de assets? [0] = money, [1] = bitcoins
	// siempre tendra 2 assets, 1 para bitcoins y otro para money
	private int quantity;
	Set<IAsset> asset = new HashSet<IAsset>();

	public EntryDTO() {

	}

	public EntryDTO(int quantity, Set<IAsset> asset) {
		this.quantity = quantity;
		this.asset = asset;
	}

	public Set<IAsset> getAssets() {
		return asset;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setAssets(Set<IAsset> asserts) {
		this.asset = asserts;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
