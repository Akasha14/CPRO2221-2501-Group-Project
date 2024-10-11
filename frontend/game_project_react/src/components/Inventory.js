
import React from 'react';
import { Tooltip } from 'react-tooltip';

const Inventory = () => {
  const items = [
    { id: 1, name: "Sword", description: "A sharp blade for melee combat" },
    { id: 2, name: "Potion", description: "Restores health" },
    { id: 3, name: "Shield", description: "A sturdy shield for defense" },
  ];

  return (
    <div className="inventory">
      {items.map((item) => (
        <div key={item.id} className="inventory-item" data-tooltip-id={item.id} data-tooltip-content={item.description}>
          {item.name}
        </div>
      ))}
      <Tooltip anchorSelect=".inventory-item" />
    </div>
  );
};

export default Inventory;
